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

package com.liveramp.megadesk.resource.lib;

import com.liveramp.megadesk.driver.ResourceDriver;
import com.liveramp.megadesk.resource.BaseResource;
import com.liveramp.megadesk.resource.Resource;
import com.liveramp.megadesk.serialization.lib.ThriftJsonSerialization;
import org.apache.thrift.TBase;

public class ThriftResource<T extends TBase>
    extends BaseResource<T>
    implements Resource<T> {

  protected ThriftResource(String id,
                           ResourceDriver driver,
                           T baseObject) {
    super(id, driver, new ThriftJsonSerialization<T>(baseObject));
  }
}
