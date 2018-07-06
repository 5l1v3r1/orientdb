/*
 * Copyright 2018 OrientDB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.orientechnologies.orient.core.delta;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.id.ORID;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marko
 */
public class ODocumentDelta {
  
  public Map<String, Object> fields = new HashMap<>();
  
  public Object field(String name){
    return fields.get(name);
  }
  
  public void field(String name, Object value){
    fields.put(name, value);
  }
  
  public ORID getIdentity(){
    throw new UnsupportedOperationException();
  }
  
  public byte[] serialize(){
    throw new UnsupportedOperationException();
  }
  
}
