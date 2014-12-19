package by.mmf.yellowpress.dao;

import by.mmf.yellowpress.domain.User;
import by.mmf.yellowpress.utils.MappingUtil;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.model.ColumnFamily;
import com.netflix.astyanax.model.Row;
import com.netflix.astyanax.model.Rows;
import com.netflix.astyanax.serializers.StringSerializer;
import org.apache.commons.collections.CollectionUtils;

import java.text.MessageFormat;
import java.util.*;

/**
 * DAO class which gets access to main operation like adding, finding & deleting for the <i>users</i> column family.
 *
 * @author dvarabyou
 */
public class UserDao extends GenericDao {

    public static final String CF_NAME = "users";
    public static final MessageFormat INSERT_QUERY =
            new MessageFormat("INSERT INTO " + CF_NAME + " (user_id, user_email, user_pass, subscribed_tags, subscribed_faculties) values(''{0}'', ''{1}'', ''{2}'', {3}, {4});");
    public static final MessageFormat FIND_BY_ID_QUERY = new MessageFormat("select * from " + CF_NAME + " where user_id = ''{0}'' limit 1;");
    public static final MessageFormat FIND_IDS_AND_SUBSCRIBED_TAGS_BY_TAG = new MessageFormat("select user_id, subscribed_tags from " + CF_NAME + " where subscribed_tags contains {0};");
    public static final MessageFormat FIND_SUBSCRIBED_TAGS_BY_USER_ID = new MessageFormat("select subscribed_tags from " + CF_NAME + " where user_id = ''{0}'';");
    public static final MessageFormat DELETE_BY_ID_QUERY = new MessageFormat("delete from " + CF_NAME + " where user_id = ''{0}'';");
    public static final MessageFormat DELETE_SUBSCRIBED_TAG_QUERY = new MessageFormat("update " + CF_NAME + " set subscribed_tags = subscribed_tags - [''{1}''] where user_id = ''{0}'';");
    public static final MessageFormat ADD_SUBSCRIBED_TAG_QUERY = new MessageFormat("update " + CF_NAME + " set subscribed_tags = subscribed_tags + [''{1}''] where user_id = ''{0}'';");
    public static final MessageFormat ADD_SUBSCRIBED_FACULTY_QUERY = new MessageFormat("update " + CF_NAME + " set subscribed_faculties = subscribed_faculties + [''{1}''] where user_id = ''{0}'';");


    public ColumnFamily<String, String> columnFamily = new ColumnFamily<String, String>(CF_NAME, StringSerializer.get(), StringSerializer.get());

    /**
     * Gets {@link by.mmf.yellowpress.domain.User} user by id.
     *
     * @param userId id of the user
     * @return
     * @throws ConnectionException
     */
    public User findById(String userId) throws ConnectionException {
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_BY_ID_QUERY.format(new Object[]{userId})).execute().getResult().getRows();
        return MappingUtil.mapUser(rows.getRowByIndex(0));
    }

    /**
     * Gets user ids and related subscribed tags by tags.
     *
     * @param tags list of tags
     * @return
     * @throws ConnectionException
     */
    public Map<String, List<String>> findUserIdsTagsByTags(List<String> tags) throws ConnectionException {
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        for (String tag : tags) {
            tag = MappingUtil.escape(tag);
            Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                    .withCql(FIND_IDS_AND_SUBSCRIBED_TAGS_BY_TAG.format(new Object[]{tag})).execute().getResult().getRows();
            for (Row<String, String> row : rows) {
                String userId = row.getColumns().getStringValue("user_id", null);
                List<String> subscribedTags = row.getColumns().getValue("subscribed_tags", MappingUtil.LIST_SERIALIZER, null);
                result.put(userId, (List<String>) CollectionUtils.intersection(subscribedTags, tags));
            }
        }
        return result;
    }

    /**
     * Adds a new {@link by.mmf.yellowpress.domain.User} user into column family.
     *
     * @param user new user to be added.
     * @throws ConnectionException
     */
    public void add(User user) throws ConnectionException {
        MappingUtil.escape(user.subscribedTags);
        MappingUtil.escape(user.subscribedFaculties);
        String insertCql = INSERT_QUERY.format(new Object[]{
                user.userId, user.userEmail, user.userPass, user.subscribedTags, user.subscribedFaculties});
        keyspace.prepareQuery(columnFamily).withCql(insertCql).execute();
    }

    public void addSubscribedTag(String userId, String tag) throws ConnectionException {
        keyspace.prepareQuery(columnFamily)
                .withCql(ADD_SUBSCRIBED_TAG_QUERY.format(new Object[]{userId, tag}))
                .execute();
    }

    public void addSubscribedFaculty(String userId, String faculty) throws ConnectionException {
        keyspace.prepareQuery(columnFamily)
                .withCql(ADD_SUBSCRIBED_FACULTY_QUERY.format(new Object[]{userId, faculty}))
                .execute();
    }

    /**
     * Deletes the {@link by.mmf.yellowpress.domain.User} user for the given id.
     *
     * @param userId id of the user to be deleted
     * @throws com.netflix.astyanax.connectionpool.exceptions.ConnectionException
     */
    public void delete(String userId) throws ConnectionException {
        keyspace.prepareQuery(columnFamily).withCql(DELETE_BY_ID_QUERY.format(new Object[]{userId})).execute();
    }

    @Override
    public String getColumnFamilyName() {
        return CF_NAME;
    }

    public List<String> getAllSubscribedTags(String userId) throws ConnectionException {
        Rows<String, String> rows = keyspace.prepareQuery(columnFamily)
                .withCql(FIND_SUBSCRIBED_TAGS_BY_USER_ID.format(new Object[]{userId})).execute().getResult().getRows();
        Row<String, String> row = rows.getRowByIndex(0);
        List<String> subscribedTags = row.getColumns().getValue("subscribed_tags", MappingUtil.LIST_SERIALIZER, null);
        return subscribedTags;
    }

    public void removeSubscription(String userId, String tag) throws ConnectionException {
        keyspace.prepareQuery(columnFamily).withCql(DELETE_SUBSCRIBED_TAG_QUERY.format(new Object[]{userId, tag}))
                .execute();
    }
}
