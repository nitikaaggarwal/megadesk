/**
 *  Copyright 2012 LiveRamp
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.liveramp.megadesk.curator;

import com.liveramp.megadesk.driver.MainDriver;
import com.liveramp.megadesk.resource.ResourcesLock;
import com.netflix.curator.framework.CuratorFramework;

public class CuratorMainDriver implements MainDriver {

  private static final String RESOURCES_LOCK_PATH = "/resources-lock";

  private final ResourcesLock resourcesLock;

  public CuratorMainDriver(CuratorFramework curator) {
    this.resourcesLock = new CuratorResourcesLock(curator, RESOURCES_LOCK_PATH);
  }

  @Override
  public ResourcesLock getResourcesLock() {
    return resourcesLock;
  }
}
