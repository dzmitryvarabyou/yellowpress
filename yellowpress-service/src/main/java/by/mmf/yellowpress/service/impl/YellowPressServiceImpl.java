package by.mmf.yellowpress.service.impl;

import by.mmf.yellowpress.dao.NewsItemByUserDao;
import by.mmf.yellowpress.dao.NewsItemDao;
import by.mmf.yellowpress.dao.UserDao;
import by.mmf.yellowpress.domain.NewsItemByUser;
import by.mmf.yellowpress.domain.NewsItem;
import by.mmf.yellowpress.service.YellowPressService;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

/**
 * @author dvarabyou
 */
public class YellowPressServiceImpl implements YellowPressService {

    public final static String NEWS_PREVIEWS_CACHE_KEY = "news_previews";
    private static final Logger LOG = LoggerFactory.getLogger(YellowPressServiceImpl.class);
    private UserDao userDao;
    private NewsItemDao newsItemDao;
    private NewsItemByUserDao newsItemByUserDao;
    public static MemcachedClient memcachedClient;

    public YellowPressServiceImpl() {
        try {
            memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            userDao = new UserDao();
            newsItemDao = new NewsItemDao();
            newsItemByUserDao = new NewsItemByUserDao();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void subscribe(String userId, String tag) {
        try {
            memcachedClient.delete(userId);
            List<NewsItem> newsItems = newsItemDao.findByTag(tag);
            newsItemByUserDao.addAll(userId, newsItems, tag);
            userDao.addSubscribedTag(userId, tag);
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void removeSubscription(String userId, String tag) {
        try {
            memcachedClient.delete(userId);
            userDao.removeSubscription(userId, tag);
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void addNewsItem(NewsItem newsItem) {
        try {
            Map<String, List<String>> userIdsTags = userDao.findUserIdsTagsByTags(newsItem.tags);
            newsItemByUserDao.addNewsByUserIds(userIdsTags, newsItem);
            newsItemDao.add(newsItem);
            for (String userId : userIdsTags.keySet()) {
                memcachedClient.delete(userId);
            }
            memcachedClient.delete(NEWS_PREVIEWS_CACHE_KEY);
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public List<NewsItemByUser> getNewsByUser(String userId) {
        List<NewsItemByUser> result = (List<NewsItemByUser>) memcachedClient.get(userId);
        try {
            if (result == null) {
                result = newsItemByUserDao.findByUserId(userId);
                memcachedClient.set(userId, 0, result);
            }
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    @Override
    public NewsItem getNewsItemById(String newsId) {
        NewsItem result = (NewsItem) memcachedClient.get(newsId);
        try {
            if (result == null) {
                result = newsItemDao.findById(newsId);
                memcachedClient.set(newsId, 0, result);
            }
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<NewsItem> getAllNewsPreviews() {
        List<NewsItem> result = (List<NewsItem>) memcachedClient.get(NEWS_PREVIEWS_CACHE_KEY);
        try {
            if (result == null) {
                result = newsItemDao.findAllWithoutBody();
                memcachedClient.set(NEWS_PREVIEWS_CACHE_KEY, 0, result);
            }
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    @Override
    public List<NewsItemByUser> getNewsByUserAndTag(String userId, String tag) {
        //TODO: cacheable
        List<NewsItemByUser> result = null;
        try {
            result = newsItemByUserDao.findByUserIdAndTag(userId, tag);
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    @Override
    public List<NewsItemByUser> getNewsItemsByUserAndFaculty(String userId, String faculty) {
        //TODO: cacheable
        List<NewsItemByUser> result = null;
        try {
            result = newsItemByUserDao.findByUserIdAndFaculty(userId, faculty);
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    @Override
    public List<NewsItemByUser> getNewsItemsByUserByTag(String tag) {
        //TODO: cacheable
        List<NewsItemByUser> result = null;
        try {
            result = newsItemByUserDao.findByTag(tag);
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    @Override
    public List<NewsItemByUser> getNewsItemsByUserByFaculty(String faculty) {
        //TODO: cacheable
        List<NewsItemByUser> result = null;
        try {
            result = newsItemByUserDao.findByFaculty(faculty);
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    @Override
    public List<NewsItem> getAllNewsItems() {
        List<NewsItem> result = null;
        try {
            result = newsItemDao.findAll();
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    @Override
    public List<String> getAllSubscribedTags(String userId) {
        List<String> result = null;
        try {
            result = userDao.getAllSubscribedTags(userId);
        } catch (ConnectionException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }
}
