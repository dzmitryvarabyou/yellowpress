package by.mmf.yellowpress.thrift.server;

import by.mmf.yellowpress.thrift.YellowPressServiceT;
import by.mmf.yellowpress.thrift.impl.YellowPressServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * @author dvarbyou
 */
public class YellowPressThriftServer {
    public static void main(String... args) {
        try {
            TServerSocket serverTransport = new TServerSocket(7912);
            YellowPressServiceT.Processor processor =
                    new YellowPressServiceT.Processor(new YellowPressServiceImpl());
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting server on port 7911 ...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
