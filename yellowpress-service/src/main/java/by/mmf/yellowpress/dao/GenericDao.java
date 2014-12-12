package by.mmf.yellowpress.dao;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.NodeDiscoveryType;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.astyanax.connectionpool.impl.CountingConnectionPoolMonitor;
import com.netflix.astyanax.impl.AstyanaxConfigurationImpl;
import com.netflix.astyanax.thrift.ThriftFamilyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Base DAO class which contains main logic for initializing and finishing connection to the db.
 *
 * @author dvarabyou
 */
public abstract class GenericDao {

    public static final String HOST = "localhost:9160";
    public static final String KEYSPACE_NAME = "yellowpress";
    protected static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected static final Logger LOG = LoggerFactory.getLogger(NewsItemDao.class);

    protected AstyanaxContext<Keyspace> astyanaxContext;
    public Keyspace keyspace;

    public GenericDao() {
        try {
            this.astyanaxContext = new AstyanaxContext.Builder()
                    .forCluster("YellowPressClusterName")
                    .forKeyspace(KEYSPACE_NAME)
                    .withAstyanaxConfiguration(new AstyanaxConfigurationImpl()
                            .setDiscoveryType(NodeDiscoveryType.NONE)
                            .setCqlVersion("3.2.0").setTargetCassandraVersion("2.1.0"))
                    .withConnectionPoolConfiguration(
                            new ConnectionPoolConfigurationImpl("YellowPressConnectionPool").setMaxConnsPerHost(1)
                                    .setSeeds(HOST)).withConnectionPoolMonitor(new CountingConnectionPoolMonitor())
                    .buildKeyspace(ThriftFamilyFactory.getInstance());

            astyanaxContext.start();
            keyspace = this.astyanaxContext.getEntity();
            // test the connection
            keyspace.describeKeyspace();
        } catch (Throwable e) {
            LOG.warn("Preparation failed.", e);
            throw new RuntimeException("Failed to prepare CassandraBolt", e);
        }
    }

    /**
     * Shuts down the connection.
     */
    public void cleanup() {
        try {
            keyspace.truncateColumnFamily(getColumnFamilyName());
            astyanaxContext.shutdown();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }

    }

    /**
     * Gets column family name depends on particular realization.
     *
     * @return name of the column family
     */
    public abstract String getColumnFamilyName();
}
