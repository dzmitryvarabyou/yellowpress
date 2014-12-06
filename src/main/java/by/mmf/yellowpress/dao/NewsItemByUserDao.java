package by.mmf.yellowpress.dao;

import by.mmf.yellowpress.domain.NewsItemByUser;
import by.mmf.yellowpress.domain.NewsItem;
import by.mmf.yellowpress.utils.MappingUtil;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.model.ColumnFamily;
import com.netflix.astyanax.model.Row;
import com.netflix.astyanax.model.Rows;
import com.netflix.astyanax.serializers.StringSerializer;

import java.text.MessageFormat;
import java.util.*;

/**
 * DAO class which gets access to main operation like adding, finding & deleting for the <i>news_by_user</i> column family.
 *
 * @author dvarabyou
 */
public class NewsItemByUserDao extends GenericDao {

    public static final String CF_NAME = "news_by_user";
    public static final MessageFormat INSERT_QUERY = new MessageFormat("INSERT INTO " + CF_NAME + " (user_id, tag, published_at, news_id, faculty, title, description, image_url)" +
            " values(''{0}'', ''{1}'', ''{2}'', ''{3}'', ''{4}'', ''{5}'', ''{6}'', ''{7}'');");
    public static final String FIND_ALL_QUERY = "select * from " + CF_NAME + ";";
    public static final MessageFormat FIND_BY_USER_ID_QUERY = new MessageFormat("select * from " + CF_NAME + " where user_id = ''{0}'';");
    public static final MessageFormat FIND_BY_USER_ID_AND_TAG_QUERY = new MessageFormat("select * from " + CF_NAME + " where user_id = ''{0}'' and tag = ''{1}'';");
    public static final MessageFormat FIND_BY_USER_ID_AND_FACULTY_QUERY = new MessageFormat("select * from " + CF_NAME + " where user_id = ''{0}'' and faculty = ''{1}'';");
    public static final MessageFormat FIND_BY_TAG_QUERY = new MessageFormat("select * from " + CF_NAME + " where tag = ''{0}'' allow filtering;");
    public static final MessageFormat FIND_BY_FACULTY_QUERY = new MessageFormat("select * from " + CF_NAME + " where faculty = ''{0}'';");
    public static final MessageFormat DELETE_BY_ID_QUERY = new MessageFormat("delete from " + CF_NAME + " where user_id = ''{0}'';");
    private ColumnFamily<String, String> columnFamily = new ColumnFamily<String, String>(CF_NAME, StringSerializer.get(), StringSerializer.get());


    /**
     * Adds a new {@link by.mmf.yellowpress.domain.NewsItemByUser} news into column family.
     *
     * @param newsItemByUser news part associated with an user.
     * @throws com.netflix.astyanax.connectionpool.exceptions.ConnectionException
     */
    public void add(NewsItemByUser newsItemByUser) throws ConnectionException {
        String insertCql = INSERT_QUERY.format(new Object[]
                {newsItemByUser.userId, newsItemByUser.tag, dateFormat.format(newsItemByUser.publishedAt),
                        newsItemByUser.newsId, newsItemByUser.faculty, newsItemByUser.title, newsItemByUser.description, newsItemByUser.imageUrl});
        keyspace.prepareQuery(columnFamily).withCql(insertCql).execute();
    }

    /**
     * Adds a new {@link by.mmf.yellowpress.domain.NewsItemByUser} news iterating on collection.
     *
     * @param newsItemsByUser collection of news parts associated with an user.
     * @throws com.netflix.astyanax.connectionpool.exceptions.ConnectionException
     */
    public void addAll(Collection<NewsItemByUser> newsItemsByUser) throws ConnectionException {
        for (NewsItemByUser item : newsItemsByUser) {
            add(item);
        }
    }

    /**
     * Adds a new {@link by.mmf.yellowpress.domain.NewsItemByUser} news iterating on collection.
     *
     * @param newsItems collection of news parts associated with an user.
     * @throws com.netflix.astyanax.connectionpool.exceptions.ConnectionException
     */
    public void addAll(String userId, Collection<NewsItem> newsItems, String tag) throws ConnectionException {
        for (NewsItem item : newsItems) {
            add(userId, item, tag);
        }
    }

    /**
     * Adds a new {@link by.mmf.yellowpress.domain.NewsItemByUser} news into column family.
     *
     * @param newsItem news item associated with an user.
     * @throws com.netflix.astyanax.connectionpool.exceptions.ConnectionException
     */
    public void add(String userId, NewsItem newsItem, String tag) throws ConnectionException {
        String insertCql = INSERT_QUERY.format(new Object[]
                {userId, tag, dateFormat.format(newsItem.publishedAt),
                        newsItem.newsId, newsItem.faculty, newsItem.title, newsItem.description, newsItem.imageUrl});
        keyspace.prepareQuery(columnFamily).withCql(insertCql).execute();
    }

    /**
     * Adds a new {@link by.mmf.yellowpress.domain.NewsItemByUser}
     * @param userIdsTags
     * @param newsItem
     * @throws ConnectionException
     */
    public void addNewsByUserIds(Map<String, List<String>> userIdsTags, NewsItem newsItem) throws ConnectionException {
        for (Map.Entry<String, List<String>> entry : userIdsTags.entrySet()) {
            add(entry.getKey(), newsItem, entry.getValue().get(0));
        }
    }

    /**
     * Finds all available {@link by.mmf.yellowpress.domain.NewsItemByUser} items.
     *
     * @return
     * @throws ConnectionException
     */
    public List<NewsItemByUser> findAll() throws ConnectionException {
        List<NewsItemByUser> result = new ArrayList<NewsItemByUser>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_ALL_QUERY).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNewsByUser(row));
        }
        return result;
    }

    /**
     * Gets {@link by.mmf.yellowpress.domain.NewsItemByUser} items by given user id.
     *
     * @param userId
     * @return
     * @throws ConnectionException
     */
    public List<NewsItemByUser> findByUserId(String userId) throws ConnectionException {
        List<NewsItemByUser> result = new ArrayList<NewsItemByUser>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_USER_ID_QUERY.format(new Object[]{userId})).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNewsByUser(row));
        }
        return result;
    }

    /**
     * Gets {@link by.mmf.yellowpress.domain.NewsItemByUser} items by given user id and tag.
     *
     * @param userId
     * @param tag
     * @return
     * @throws ConnectionException
     */
    public List<NewsItemByUser> findByUserIdAndTag(String userId, String tag) throws ConnectionException {
        List<NewsItemByUser> result = new ArrayList<NewsItemByUser>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_USER_ID_AND_TAG_QUERY.format(new Object[]{userId, tag})).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNewsByUser(row));
        }
        return result;
    }

    /**
     * Gets {@link by.mmf.yellowpress.domain.NewsItemByUser} items by given user id and faculty.
     *
     * @param userId
     * @param faculty
     * @return
     * @throws ConnectionException
     */
    public List<NewsItemByUser> findByUserIdAndFaculty(String userId, String faculty) throws ConnectionException {
        List<NewsItemByUser> result = new ArrayList<NewsItemByUser>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_USER_ID_AND_FACULTY_QUERY.format(new Object[]{userId, faculty})).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNewsByUser(row));
        }
        return result;
    }

    /**
     * Gets {@link by.mmf.yellowpress.domain.NewsItemByUser} items by given tag.
     *
     * @param tag
     * @return
     * @throws ConnectionException
     */
    public List<NewsItemByUser> findByTag(String tag) throws ConnectionException {
        List<NewsItemByUser> result = new ArrayList<NewsItemByUser>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_TAG_QUERY.format(new Object[]{tag})).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNewsByUser(row));
        }
        return result;
    }

    /**
     * Gets {@link by.mmf.yellowpress.domain.NewsItemByUser} items by given faculty.
     *
     * @param faculty
     * @return
     * @throws ConnectionException
     */
    public List<NewsItemByUser> findByFaculty(String faculty) throws ConnectionException {
        List<NewsItemByUser> result = new ArrayList<NewsItemByUser>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_FACULTY_QUERY.format(new Object[]{faculty})).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNewsByUser(row));
        }
        return result;
    }

    /**
     * Deletes the {@link by.mmf.yellowpress.domain.NewsItemByUser} items by the given news id.
     *
     * @param newsId id of the news to be deleted
     * @throws ConnectionException
     */
    public void delete(String newsId) throws ConnectionException {
        keyspace.prepareQuery(columnFamily).withCql(DELETE_BY_ID_QUERY.format(new Object[]{newsId})).execute();
    }

    @Override
    public String getColumnFamilyName() {
        return CF_NAME;
    }
}
