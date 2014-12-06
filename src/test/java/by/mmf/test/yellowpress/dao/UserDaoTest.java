package by.mmf.test.yellowpress.dao;

import by.mmf.yellowpress.dao.UserDao;
import by.mmf.yellowpress.domain.User;
import by.mmf.yellowpress.utils.MappingUtil;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.model.CqlResult;
import org.junit.*;

import java.util.ArrayList;

/**
 * Test class prepared for testing only {@link by.mmf.yellowpress.dao.UserDao}
 *
 * @author dvarabyou
 */
public class UserDaoTest {

    private static UserDao dao;
    private static User SAMPLE_USER;

    @BeforeClass
    public static void init() {
        dao = new UserDao();
        SAMPLE_USER = new User();
        SAMPLE_USER.userId = "jack";
        SAMPLE_USER.userEmail = "jack@mail.com";
        SAMPLE_USER.userPass = "12345";
        SAMPLE_USER.subscribedTags = new ArrayList<String>() {{
            this.add("#mmf");
        }};
        SAMPLE_USER.subscribedFaculties = new ArrayList<String>() {{
            this.add("MMF");
        }};
    }

    @AfterClass
    public static void tearDown() throws Exception {
        dao.cleanup();
    }

    @Before
    public void before() throws ConnectionException {
        dao.add(SAMPLE_USER);
    }

    @After
    public void after() throws ConnectionException {
        dao.delete(SAMPLE_USER.userId);
    }

    @Test
    public void testFindById() throws Exception {
        Assert.assertNotNull(dao.findById(SAMPLE_USER.userId));
    }

    @Test
    public void testFindUserIdsByTags() throws Exception {
        Assert.assertEquals(1, dao.findUserIdsTagsByTags(SAMPLE_USER.subscribedTags).size());
    }

    @Test
    public void testAddSubscribedTag() throws Exception {
        dao.addSubscribedTag(SAMPLE_USER.userId, "#fpmi");
        CqlResult<String, String> cqlResult = dao.keyspace.prepareQuery(dao.columnFamily)
                .withCql("select subscribed_tags from users where user_id = '" + SAMPLE_USER.userId + "';")
                .execute().getResult();

        int size = cqlResult.getRows().getRowByIndex(0).getColumns().getValue("subscribed_tags", MappingUtil.LIST_SERIALIZER, null).size();
        Assert.assertEquals(2, size);
    }

    @Test
    public void testAddSubscribedFaculty() throws Exception {
        dao.addSubscribedFaculty(SAMPLE_USER.userId, "FPMI");
        CqlResult<String, String> cqlResult = dao.keyspace.prepareQuery(dao.columnFamily)
                .withCql("select subscribed_faculties from users where user_id = '" + SAMPLE_USER.userId + "';")
                .execute().getResult();

        int size = cqlResult.getRows().getRowByIndex(0).getColumns().getValue("subscribed_faculties", MappingUtil.LIST_SERIALIZER, null).size();
        Assert.assertEquals(2, size);
    }
}
