package by.mmf.test.yellowpress.dao;

import by.mmf.yellowpress.dao.NewsItemByUserDao;
import by.mmf.yellowpress.domain.NewsItemByUser;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import junit.framework.Assert;
import org.junit.*;

import java.util.Date;

/**
 * @author dvarabyou
 */
public class NewsItemByUserDaoTest {

    private static NewsItemByUserDao dao;
    private static NewsItemByUser SAMPLE_NEWS_BY_USER_ITEM;

    @BeforeClass
    public static void init() {
        dao = new NewsItemByUserDao();
        SAMPLE_NEWS_BY_USER_ITEM = new NewsItemByUser();
        SAMPLE_NEWS_BY_USER_ITEM.userId = "user_id_1";
        SAMPLE_NEWS_BY_USER_ITEM.tag = "#mmf";
        SAMPLE_NEWS_BY_USER_ITEM.publishedAt = new Date();
        SAMPLE_NEWS_BY_USER_ITEM.newsId = "news_id_1";
        SAMPLE_NEWS_BY_USER_ITEM.title = "MMF Big brothers.";
        SAMPLE_NEWS_BY_USER_ITEM.description = "Hey mmf people.";
        SAMPLE_NEWS_BY_USER_ITEM.imageUrl = "http://some_img.png";
        SAMPLE_NEWS_BY_USER_ITEM.faculty = "MMF";
    }

    @AfterClass
    public static void tearDown() throws Exception {
        dao.cleanup();
    }

    @Before
    public void before() throws ConnectionException {
        dao.add(SAMPLE_NEWS_BY_USER_ITEM);
    }

    @After
    public void after() throws ConnectionException {
        dao.delete(SAMPLE_NEWS_BY_USER_ITEM.userId);
    }

    @Test
    public void testFindById() throws Exception {
        Assert.assertEquals(1, dao.findByUserId(SAMPLE_NEWS_BY_USER_ITEM.userId).size());
    }

    @Test
    public void testFindByIdAndTag() throws Exception {
        Assert.assertEquals(1, dao.findByUserIdAndTag(SAMPLE_NEWS_BY_USER_ITEM.userId, SAMPLE_NEWS_BY_USER_ITEM.tag).size());
    }

    @Test
    public void testFindByIdAndFaculty() throws Exception {
        Assert.assertEquals(1, dao.findByUserIdAndFaculty(SAMPLE_NEWS_BY_USER_ITEM.userId, SAMPLE_NEWS_BY_USER_ITEM.faculty).size());
    }

    @Test
    public void testFindByTag() throws Exception {
        Assert.assertEquals(1, dao.findByTag(SAMPLE_NEWS_BY_USER_ITEM.tag).size());
    }

    @Test
    public void testFindByFaculty() throws Exception {
        Assert.assertEquals(1, dao.findByFaculty(SAMPLE_NEWS_BY_USER_ITEM.faculty).size());
    }
}
