package com.liveramp.megadesk.step;

import com.liveramp.megadesk.resource.Resource;

import java.util.List;

public abstract class BaseStep implements Step {

  private String id;
  private final List<Resource> reads;
  private final List<Resource> writes;

  public BaseStep(String id,
                  List<Resource> reads,
                  List<Resource> writes) {
    this.id = id;
    this.reads = reads;
    this.writes = writes;
  }

  public String getId() {
    return id;
  }

  public abstract StepLock getStepLock();

  @Override
  public List<Resource> getReads() {
    return reads;
  }

  @Override
  public List<Resource> getWrites() {
    return writes;
  }

  public void attempt() throws Exception {
    // Acquire all locks
    // TODO: potential dead locks
    getStepLock().acquire();
    for (Resource read : reads) {
      read.getReadLock().acquire(this);
    }
    for (Resource write : writes) {
      write.getWriteLock().acquire(this);
    }
  }

  public void complete() throws Exception {
    // Release all locks
    for (Resource read : reads) {
      read.getReadLock().release(this);
    }
    for (Resource write : writes) {
      write.getWriteLock().release(this);
    }
    getStepLock().release();
  }
}