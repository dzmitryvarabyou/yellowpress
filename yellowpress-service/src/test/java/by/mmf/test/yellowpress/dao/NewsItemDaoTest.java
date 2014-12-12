package by.mmf.test.yellowpress.dao;

import by.mmf.yellowpress.dao.NewsItemDao;
import by.mmf.yellowpress.domain.NewsItem;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import junit.framework.Assert;
import org.junit.*;

import java.util.ArrayList;

/**
 * Test class prepared for testing only {@link by.mmf.yellowpress.dao.NewsItemDao}
 *
 * @author dvarabyou
 */
public class NewsItemDaoTest {

    private static NewsItemDao dao;
    private static NewsItem SAMPLE_NEWS_ITEM;

    @BeforeClass
    public static void init() {
        dao = new NewsItemDao();
        SAMPLE_NEWS_ITEM = new NewsItem();
        SAMPLE_NEWS_ITEM.newsId = "news_1";
        SAMPLE_NEWS_ITEM.title = "The big deal";
        SAMPLE_NEWS_ITEM.body = "In year 2014...";
        SAMPLE_NEWS_ITEM.imageUrl = "http://mmf.bsu.by//bigdeal.png";
        SAMPLE_NEWS_ITEM.faculty = "MMF";
        SAMPLE_NEWS_ITEM.tags = new ArrayList<String>() {{
            this.add("#mmf");
            this.add("#1love");
        }};
    }

    @AfterClass
    public static void tearDown() throws Exception {
        dao.cleanup();
    }

    @Before
    public void before() throws ConnectionException {
        dao.add(SAMPLE_NEWS_ITEM);
    }

    @After
    public void after() throws ConnectionException {
        dao.delete(SAMPLE_NEWS_ITEM.newsId);
    }

    @Test
    public void testFindById() throws Exception {
        Assert.assertNotNull(dao.findById(SAMPLE_NEWS_ITEM.newsId));
    }

    @Test
    public void testFindAll() throws Exception {
        Assert.assertEquals(1, dao.findAll().size());
    }

    @Test
    public void testFindByTag() throws Exception {
        Assert.assertNotNull(dao.findByTag(SAMPLE_NEWS_ITEM.tags.get(0)));
    }

    @Test
    public void testFindByFaculty() throws Exception {
        Assert.assertNotNull(dao.findByFaculty(SAMPLE_NEWS_ITEM.faculty));
    }
}
