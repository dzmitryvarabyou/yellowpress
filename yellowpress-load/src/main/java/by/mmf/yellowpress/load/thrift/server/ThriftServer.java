package by.mmf.yellowpress.load.thrift.server;

import by.mmf.yellowpress.load.thrift.impl.YellowPressServiceImpl;
import by.mmf.yellowpress.thrift.YellowPressServiceT;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author dvarabyou
 */
public class ThriftServer {
    public static void main(String... args) {
        try {
            TServerSocket serverTransport = new TServerSocket(7911);
            YellowPressServiceT.Processor processor =
                    new YellowPressServiceT.Processor(new YellowPressServiceImpl());
            TServer server = new TThreadPoolServer(processor, serverTransport);
            System.out.println("Starting server on port 7911 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
