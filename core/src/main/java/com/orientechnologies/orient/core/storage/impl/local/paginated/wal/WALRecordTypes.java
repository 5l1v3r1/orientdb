package com.orientechnologies.orient.core.storage.impl.local.paginated.wal;

@SuppressWarnings("WeakerAccess")
public final class WALRecordTypes {
  //removed: public static final byte UPDATE_PAGE_RECORD                    = 0;
  public static final byte FUZZY_CHECKPOINT_START_RECORD         = 1;
  public static final byte FUZZY_CHECKPOINT_END_RECORD           = 2;
  public static final byte FULL_CHECKPOINT_START_RECORD          = 4;
  public static final byte CHECKPOINT_END_RECORD                 = 5;
  public static final byte ATOMIC_UNIT_START_RECORD              = 8;
  public static final byte ATOMIC_UNIT_END_RECORD                = 9;
  public static final byte FILE_CREATED_WAL_RECORD               = 10;
  public static final byte NON_TX_OPERATION_PERFORMED_WAL_RECORD = 11;
  public static final byte FILE_DELETED_WAL_RECORD               = 12;
  //removed: public static final byte FILE_TRUNCATED_WAL_RECORD             = 13;
  public static final byte EMPTY_WAL_RECORD                      = 14;

  public static final byte CREATE_CLUSTER_CO                   = 15;
  public static final byte DELETE_CLUSTER_CO                   = 16;
  public static final byte CLUSTER_CREATE_RECORD_CO            = 17;
  public static final byte CLUSTER_DELETE_RECORD_CO            = 18;
  public static final byte CLUSTER_ALLOCATE_RECORD_POSITION_CO = 19;
  public static final byte CLUSTER_UPDATE_RECORD_CO            = 20;

  public static final byte INDEX_ENGINE_CREATE_CO = 21;
  public static final byte INDEX_ENGINE_DELETE_CO = 22;

  public static final byte CELL_BTREE_SINGLE_VALUE_PUT_CO    = 23;
  public static final byte CELL_BTREE_SINGLE_VALUE_DELETE_CO = 24;
}
