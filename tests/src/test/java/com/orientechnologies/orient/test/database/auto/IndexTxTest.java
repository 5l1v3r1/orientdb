package com.orientechnologies.orient.test.database.auto;

import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OSchema;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Artem Orobets (enisher-at-gmail.com)
 */
public class IndexTxTest extends DocumentDBBaseTest {

  @Parameters(value = "url")
  public IndexTxTest(@Optional String url) {
    super(url);
  }

  @BeforeClass
  public void beforeClass() throws Exception {
    super.beforeClass();

    final OSchema schema = database.getMetadata().getSchema();
    final OClass cls = schema.createClass("IndexTxTestClass");
    cls.createProperty("name", OType.STRING);
    cls.createIndex("IndexTxTestIndex", OClass.INDEX_TYPE.UNIQUE, "name");
  }

  @BeforeMethod
  public void beforeMethod() throws Exception {
    super.beforeMethod();

    final OSchema schema = database.getMetadata().getSchema();
    final OClass cls = schema.getClass("IndexTxTestClass");
    if (cls != null) {
      cls.truncate();
    }
  }

  @Test
  public void testIndexCrossReferencedDocuments() throws Exception {
    database.begin();

    final ODocument doc1 = new ODocument("IndexTxTestClass");
    final ODocument doc2 = new ODocument("IndexTxTestClass");

    doc1.save();
    doc2.save();

    doc1.field("ref", doc2.getIdentity().copy());
    doc1.field("name", "doc1");
    doc2.field("ref", doc1.getIdentity().copy());
    doc2.field("name", "doc2");

    doc1.save();
    doc2.save();

    database.commit();

    Map<String, ORID> expectedResult = new HashMap<String, ORID>();
    expectedResult.put("doc1", doc1.getIdentity());
    expectedResult.put("doc2", doc2.getIdentity());

    final List<ODocument> result = database.query(new OSQLSynchQuery<>("select from index:IndexTxTestIndex"));
    for (ODocument o : result) {
      final String key = o.rawField("key");
      final ORID expectedValue = expectedResult.get(key);
      final ORID value = o.rawField("rid");
      Assert.assertTrue(value.isPersistent());
      Assert.assertEquals(value, expectedValue);
    }
  }
}
