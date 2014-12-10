package by.mmf.yellowpress.utils;

import by.mmf.yellowpress.domain.NewsItem;
import by.mmf.yellowpress.domain.NewsItemByUser;
import by.mmf.yellowpress.domain.User;
import com.netflix.astyanax.model.ColumnList;
import com.netflix.astyanax.model.Row;
import com.netflix.astyanax.serializers.ListSerializer;
import org.apache.cassandra.db.marshal.UTF8Type;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.List;

/**
 * Created by jack on 11/30/14.
 */
public class MappingUtil {

    public static final ListSerializer<String> LIST_SERIALIZER = new ListSerializer<String>(UTF8Type.instance);

    public static NewsItem mapNews(Row<String, String> row) {
        ColumnList<String> columns = row.getColumns();
        return mapNews(columns);
    }

    public static NewsItem mapNews(ColumnList<String> columns) {
        NewsItem result = new NewsItem();
        result.newsId = columns.getStringValue("news_id", null);
        result.publishedAt = columns.getDateValue("published_at", null);
        result.lastModifiedAt = columns.getDateValue("last_modified_at", null);
        result.title = columns.getStringValue("title", null);
        result.body = columns.getStringValue("body", null);
        result.faculty = columns.getStringValue("faculty", null);
        result.imageUrl = columns.getStringValue("image_url", null);
        result.tags = columns.getValue("tags", LIST_SERIALIZER, null);
        return result;
    }

    public static User mapUser(Row<String, String> row) {
        ColumnList<String> columns = row.getColumns();
        return mapUser(columns);
    }

    public static User mapUser(ColumnList<String> columns) {
        User result = new User();
        result.userId = columns.getStringValue("user_id", null);
        result.userEmail = columns.getStringValue("user_email", null);
        result.userPass = columns.getStringValue("user_pass", null);
        result.subscribedTags = columns.getValue("subscribed_tags", LIST_SERIALIZER, null);
        result.subscribedFaculties = columns.getValue("subscribed_faculties", LIST_SERIALIZER, null);
        return result;
    }

    public static void escape(List<String> original) {
        if (original != null)
            CollectionUtils.transform(original, new Transformer() {
                @Override
                public Object transform(Object o) {
                    return escape(o.toString());
                }
            });
    }

    public static String escape(String original) {
        if (!original.toString().startsWith("'"))
            return "'" + original + "'";
        else
            return original;

    }

    public static NewsItemByUser mapNewsByUser(Row<String, String> row) {
        ColumnList<String> columns = row.getColumns();
        return mapNewsByUser(columns);
    }

    private static NewsItemByUser mapNewsByUser(ColumnList<String> columns) {
        NewsItemByUser result = new NewsItemByUser();
        result.userId = columns.getStringValue("user_id", null);
        result.tag = columns.getStringValue("tag", null);
        result.publishedAt = columns.getDateValue("published_at", null);
        result.newsId = columns.getStringValue("news_id", null);
        result.title = columns.getStringValue("title", null);
        result.description = columns.getStringValue("description", null);
        result.imageUrl = columns.getStringValue("image_url", null);
        result.faculty = columns.getStringValue("faculty", null);
        return result;
    }

    public static void copyProperties(by.mmf.yellowpress.thrift.gen.NewsItemByUser dest, NewsItemByUser orig) {
        dest.userId = orig.userId;
        dest.tag = orig.tag;
        dest.publishedAt = orig.publishedAt.toString();
        dest.newsId = orig.newsId;
        dest.title = orig.title;
        dest.description = orig.description;
        dest.imageUrl = orig.imageUrl;
        dest.faculty = orig.faculty;
    }
}
