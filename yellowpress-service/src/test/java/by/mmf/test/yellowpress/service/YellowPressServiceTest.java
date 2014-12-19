package by.mmf.test.yellowpress.service;

import by.mmf.yellowpress.dao.NewsItemByUserDao;
import by.mmf.yellowpress.dao.NewsItemDao;
import by.mmf.yellowpress.dao.UserDao;
import by.mmf.yellowpress.domain.NewsItem;
import by.mmf.yellowpress.domain.User;
import by.mmf.yellowpress.service.YellowPressService;
import by.mmf.yellowpress.service.impl.YellowPressServiceImpl;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import junit.framework.Assert;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author dvarabyou
 */
public class YellowPressServiceTest {

    protected static final Logger LOG = LoggerFactory.getLogger(YellowPressServiceTest.class);
    private static YellowPressService yellowPressService;
    private static User user;
    private static UserDao userDao;
    private static NewsItemDao newsItemDao;
    private static NewsItemByUserDao newsItemByUserDao;

    @BeforeClass
    public static void init() throws Exception {
        userDao = new UserDao();
        newsItemDao = new NewsItemDao();
        newsItemByUserDao = new NewsItemByUserDao();
        yellowPressService = new YellowPressServiceImpl();

    }

    @AfterClass
    public static void tearDown() {
        userDao.cleanup();
        newsItemDao.cleanup();
        newsItemByUserDao.cleanup();
    }

    @Before
    public void before() throws ConnectionException {
        initNewsItems();
        initUser();
        yellowPressService.subscribe(user.userId, "#tag1");
    }

    private void initNewsItems() throws ConnectionException {
        for (int i = 0; i < 5; i++) {
            NewsItem newsItem = new NewsItem();
            newsItem.newsId = "news_id_" + i;
            newsItem.title = "News title " + i;
            newsItem.body = "News content " + i;
            newsItem.imageUrl = "http://news_image_url_" + i;
            newsItem.faculty = "faculty " + i;
            newsItem.tags = new ArrayList<String>();
            newsItem.tags.add("#tag" + i);

            newsItemDao.add(newsItem);
            newsItem.newsId = "news_id_" + i + i;
            newsItemDao.add(newsItem);
        }
    }

    private void initUser() throws ConnectionException {
        user = new User();
        user.userId = "jack";
        user.userEmail = "jack@mail.com";
        user.userPass = "12345";
        userDao.add(user);
    }

    @After
    public void after() throws ConnectionException {
        newsItemDao.keyspace.truncateColumnFamily(newsItemDao.getColumnFamilyName());
        newsItemByUserDao.keyspace.truncateColumnFamily(newsItemByUserDao.getColumnFamilyName());
        userDao.keyspace.truncateColumnFamily(userDao.getColumnFamilyName());
        YellowPressServiceImpl.memcachedClient.delete(user.userId);
    }

    @Test
    public void testSubscribe() throws ConnectionException {
        yellowPressService.subscribe(user.userId, "#tag2");
        Assert.assertEquals(4, newsItemByUserDao.findByUserId(user.userId).size());

    }

    @Test
    public void testGetAllSubscribedTags() {
        yellowPressService.subscribe(user.userId, "#tag2");
        Assert.assertEquals(2, yellowPressService.getAllSubscribedTags(user.userId).size());
    }

    @Test
    public void testGetNewsItem() {
        String newsId = "news_id_1";
        Assert.assertEquals(newsId, yellowPressService.getNewsItemById(newsId).newsId);
    }

    @Test
    public void testGetNewsByUser() throws ConnectionException {
        Assert.assertEquals(2, yellowPressService.getNewsByUser(user.userId).size());
    }

    @Test
    public void testAddNews() throws ConnectionException {
        NewsItem newsItem = new NewsItem();
        newsItem.newsId = "news_id";
        newsItem.title = "News title";
        newsItem.body = "News content";
        newsItem.publishedAt = new Date();
        newsItem.imageUrl = "http://news_image_url";
        newsItem.faculty = "faculty";
        newsItem.tags = new ArrayList<String>();
        newsItem.tags.add("#tag1");
        yellowPressService.addNewsItem(newsItem);
        Assert.assertEquals(3, yellowPressService.getNewsByUser(user.userId).size());
    }
}
