package com.orientechnologies.orient.core.storage.impl.local.paginated.wal.co;

import com.orientechnologies.orient.core.storage.impl.local.OAbstractPaginatedStorage;
import com.orientechnologies.orient.core.storage.impl.local.paginated.atomicoperations.OAtomicOperation;
import com.orientechnologies.orient.core.storage.impl.local.paginated.wal.OOperationUnitBodyRecord;
import com.orientechnologies.orient.core.storage.impl.local.paginated.wal.OOperationUnitId;

public abstract class OComponentOperationRecord extends OOperationUnitBodyRecord {
  public OComponentOperationRecord() {
  }

  public OComponentOperationRecord(final OOperationUnitId operationUnitId) {
    super(operationUnitId);
  }

  @Override
  public boolean isUpdateMasterRecord() {
    return false;
  }

  public abstract void undo(OAbstractPaginatedStorage storage, OAtomicOperation atomicOperation);

  public abstract void redo(OAbstractPaginatedStorage storage, OAtomicOperation atomicOperation);
}
