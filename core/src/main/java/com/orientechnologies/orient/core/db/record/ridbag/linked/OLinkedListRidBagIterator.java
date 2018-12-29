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
package com.orientechnologies.orient.core.db.record.ridbag.linked;

import com.orientechnologies.common.log.OLogManager;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.exception.ODatabaseException;
import com.orientechnologies.orient.core.storage.cluster.linkedridbags.OFastRidBagPaginatedCluster;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author marko
 */
public class OLinkedListRidBagIterator implements Iterator<OIdentifiable>{
  
  public OLinkedListRidBagIterator(OLinkedListRidBag ridbag){
    
  }
  
  @Override
  public boolean hasNext() {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public OIdentifiable next() {
    throw new UnsupportedOperationException("Not implemented");
  }
  
  @Override
  public void remove(){
    
  }
  
}
