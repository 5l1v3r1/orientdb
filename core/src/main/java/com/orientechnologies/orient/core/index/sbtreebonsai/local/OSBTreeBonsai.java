package com.orientechnologies.orient.core.index.sbtreebonsai.local;

import java.util.Collection;
import java.util.Map;

import com.orientechnologies.common.serialization.types.OBinarySerializer;
import com.orientechnologies.orient.core.db.record.ridbag.sbtree.OBonsaiCollectionPointer;
import com.orientechnologies.orient.core.db.record.ridbag.sbtree.OSBTreeRidBag;
import com.orientechnologies.orient.core.index.hashindex.local.cache.ODiskCache;
import com.orientechnologies.orient.core.index.sbtree.OTreeInternal;
import com.orientechnologies.orient.core.index.sbtree.local.OSBTree;

/**
 * The tree that have similar structure to {@link OSBTree} and designed to store small entries. <br/>
 * <br/>
 * The tree algorithm is the same as in {@link OSBTree}, but it have tiny buckets.<br/>
 * The {@link ODiskCache} could contain several buckets. That's why there is no huge resource consuming when you have lots of
 * OSBTreeBonsai that contain only few records.<br/>
 * <br/>
 * <code>
 * +--------------------------------------------------------------------------------------------+<br/>
 * | DISK CACHE PAGE                                                                            |<br/>
 * |+---------------+ +---------------+ +---------------+ +---------------+ +---------------+   |<br/>
 * || Bonsai Bucket | | Bonsai Bucket | | Bonsai Bucket | | Bonsai Bucket | | Bonsai Bucket |...|<br/>
 * |+---------------+ +---------------+ +---------------+ +---------------+ +---------------+   |<br/>
 * +--------------------------------------------------------------------------------------------+<br/>
 * </code>
 * 
 * @author <a href="mailto:enisher@gmail.com">Artem Orobets</a>
 * @since 1.7rc1
 */
public interface OSBTreeBonsai<K, V> extends OTreeInternal<K, V> {
  /**
   * Gets id of file where this bonsai tree is stored.
   * 
   * @return id of file in {@link ODiskCache}
   */
  long getFileId();

  OBonsaiBucketPointer getRootBucketPointer();

  OBonsaiCollectionPointer getCollectionPointer();

  V get(K key);

  boolean put(K key, V value);

  void clear();

  void delete();

  long size();

  V remove(K key);

  Collection<V> getValuesMinor(K key, boolean inclusive, int maxValuesToFetch);

  void loadEntriesMinor(K key, boolean inclusive, RangeResultListener<K, V> listener);

  Collection<V> getValuesMajor(K key, boolean inclusive, int maxValuesToFetch);

  void loadEntriesMajor(K key, boolean inclusive, boolean ascSortOrder, RangeResultListener<K, V> listener);

  Collection<V> getValuesBetween(K keyFrom, boolean fromInclusive, K keyTo, boolean toInclusive, int maxValuesToFetch);

  K firstKey();

  K lastKey();

  void loadEntriesBetween(K keyFrom, boolean fromInclusive, K keyTo, boolean toInclusive, RangeResultListener<K, V> listener);

  /**
   * Hardcoded method for Bag to avoid creation of extra layer.
   * <p/>
   * Don't make any changes to tree.
   * 
   * @param changes
   *          Bag changes
   * @return real bag size
   */
  int getRealBagSize(Map<K, OSBTreeRidBag.Change> changes);

  OBinarySerializer<K> getKeySerializer();

  OBinarySerializer<V> getValueSerializer();
}
