package by.mmf.yellowpress.thrift.server;

import by.mmf.yellowpress.thrift.gen.YellowPressService;
import by.mmf.yellowpress.thrift.impl.YellowPressServiceImpl;
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
            YellowPressService.Processor processor =
                    new YellowPressService.Processor(new YellowPressServiceImpl());
            TServer server = new TThreadPoolServer(
                    new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting server on port 7911 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
