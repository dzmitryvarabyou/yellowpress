package by.mmf.yellowpress.dao;

import by.mmf.yellowpress.domain.NewsItem;
import by.mmf.yellowpress.utils.MappingUtil;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.model.ColumnFamily;
import com.netflix.astyanax.model.Row;
import com.netflix.astyanax.model.Rows;
import com.netflix.astyanax.serializers.StringSerializer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * DAO class which gets access to main operation like adding, finding & deleting for the <i>news</i> column family.
 *
 * @author dvarabyou
 */
public class NewsItemDao extends GenericDao {

    public static final String CF_NAME = "news";
    public static final MessageFormat INSERT_QUERY = new MessageFormat("INSERT INTO " + CF_NAME + " (news_id, published_at, last_modified_at, title, body, faculty, image_url, tags)" +
            " values(''{0}'', ''{1}'', ''{2}'', ''{3}'', ''{4}'', ''{5}'', ''{6}'', {7});");
    public static final MessageFormat FIND_BY_ID_QUERY = new MessageFormat("select * from " + CF_NAME + " where news_id = ''{0}'' limit 1;");
    public static final String FIND_ALL_QUERY = "select * from " + CF_NAME + ";";
    public static final MessageFormat FIND_BY_TAG_QUERY = new MessageFormat("select * from " + CF_NAME + " where tags CONTAINS {0};");
    public static final MessageFormat FIND_BY_FACULTY_QUERY = new MessageFormat("select * from " + CF_NAME + " where faculty = ''{0}'';");
    public static final MessageFormat DELETE_BY_ID_QUERY = new MessageFormat("delete from " + CF_NAME + " where news_id = ''{0}'';");
    private ColumnFamily<String, String> columnFamily = new ColumnFamily<String, String>(CF_NAME, StringSerializer.get(), StringSerializer.get());

    /**
     * Adds a new {@link by.mmf.yellowpress.domain.NewsItem} news item into column family.
     *
     * @param item new news item to be added.
     * @throws ConnectionException
     */
    public void add(NewsItem item) throws ConnectionException {
        item.publishedAt = new Date();
        item.lastModifiedAt = item.publishedAt;
        MappingUtil.escape(item.tags);
        String insertCql = INSERT_QUERY.format(new Object[]
                {item.newsId, dateFormat.format(item.publishedAt), dateFormat.format(item.lastModifiedAt),
                        item.title, item.body, item.faculty, item.imageUrl, item.tags});
        keyspace.prepareQuery(columnFamily).withCql(insertCql).execute();
    }

    /**
     * Gets {@link by.mmf.yellowpress.domain.NewsItem} news item by id.
     *
     * @param newsId
     * @return
     * @throws ConnectionException
     */
    public NewsItem findById(String newsId) throws ConnectionException {
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_ID_QUERY.format(new Object[]{newsId})).execute().getResult().getRows();
        return MappingUtil.mapNews(rows.getRowByIndex(0));
    }

    /**
     * Finds all available {@link by.mmf.yellowpress.domain.NewsItem} news items.
     *
     * @return
     * @throws ConnectionException
     */
    public List<NewsItem> findAll() throws ConnectionException {
        List<NewsItem> result = new ArrayList<NewsItem>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_ALL_QUERY).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNews(row));
        }
        return result;
    }

    /**
     * Fetches all {@link by.mmf.yellowpress.domain.NewsItem} news items which contains the given tag.
     *
     * @param tag the tag to search on
     * @return list of {@link by.mmf.yellowpress.domain.NewsItem} news item objects
     * @throws ConnectionException
     */
    public List<NewsItem> findByTag(String tag) throws ConnectionException {
        tag = MappingUtil.escape(tag);
        List<NewsItem> result = new ArrayList<NewsItem>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_TAG_QUERY.format(new Object[]{tag})).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNews(row));
        }
        return result;
    }

    /**
     * Fetches all {@link by.mmf.yellowpress.domain.NewsItem} news items for given faculty.
     *
     * @param faculty the tag to search on
     * @return list of {@link by.mmf.yellowpress.domain.NewsItem} news item objects
     * @throws ConnectionException
     */
    public List<NewsItem> findByFaculty(String faculty) throws ConnectionException {
        List<NewsItem> result = new ArrayList<NewsItem>();
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_FACULTY_QUERY.format(new Object[]{faculty})).execute().getResult().getRows();
        for (Row<String, String> row : rows) {
            result.add(MappingUtil.mapNews(row));
        }
        return result;
    }

    /**
     * Deletes the {@link by.mmf.yellowpress.domain.NewsItem} news items for the given id.
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
