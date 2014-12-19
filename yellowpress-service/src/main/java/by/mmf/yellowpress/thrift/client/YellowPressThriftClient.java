package by.mmf.yellowpress.thrift.client;

import by.mmf.yellowpress.thrift.NewsItemByUserT;
import by.mmf.yellowpress.thrift.YellowPressServiceT;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;

import java.util.List;

/**
 * @author dvarabyou
 */
public class YellowPressThriftClient {
    public static void main(String[] args) {
        try {
            TSocket transport = new TSocket("localhost", 7911);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);

            YellowPressServiceT.Client client = new YellowPressServiceT.Client(protocol);

            List<NewsItemByUserT> result = client.getNewsByUser("jack");
            System.out.println("Return from server: " + result);
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
