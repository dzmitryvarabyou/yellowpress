package by.mmf.yellowpress.thrift.client;

import by.mmf.yellowpress.thrift.gen.NewsItemByUser;
import by.mmf.yellowpress.thrift.gen.YellowPressService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;

import java.util.List;

/**
 * @author dvarabyou
 */
public class ThriftClient {
    public static void main(String[] args) {
        try {
            TSocket transport = new TSocket("localhost", 7911);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);

            YellowPressService.Client client = new YellowPressService.Client(protocol);

            List<NewsItemByUser> result = client.getNewsByUser("jack");
            System.out.println("Return from server: " + result);
            transport.close();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
