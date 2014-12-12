package by.mmf.yellowpress.load;

import by.mmf.yellowpress.domain.NewsItemByUser;
import by.mmf.yellowpress.thrift.NewsItemByUserT;
import by.mmf.yellowpress.thrift.YellowPressServiceT;
import com.twitter.parrot.processor.ThriftLoadTest;
import com.twitter.parrot.server.ParrotRequest;
import com.twitter.parrot.server.ParrotService;
import com.twitter.util.Future;
import com.twitter.util.FutureEventListener;
import org.apache.thrift.protocol.TBinaryProtocol;


import java.util.List;

/**
 * @author dvarabyou
 */
public class YellowPressLoadTest extends ThriftLoadTest {

    private YellowPressServiceT.ServiceToClient client;

    public YellowPressLoadTest(ParrotService<ParrotRequest, byte[]> pService) {
        super(pService);
        client = new YellowPressServiceT.ServiceToClient(service(), new TBinaryProtocol.Factory());
    }

    @Override
    public void processLines(List<String> lines) {
        for (String userId : lines) {
            Future<List<NewsItemByUserT>> future = client.getNewsByUser(userId);
            future.addEventListener(new FutureEventListener<List<NewsItemByUserT>>() {
                public void onSuccess(List<NewsItemByUserT> newsItemsByUser) {
                    System.out.println("response: " + newsItemsByUser);
                }

                public void onFailure(Throwable cause) {
                    System.out.println("Error: " + cause);
                }
            });
        }
    }
}
