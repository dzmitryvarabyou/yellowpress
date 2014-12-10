package by.mmf.yellowpress.thrift.impl;

import by.mmf.yellowpress.thrift.gen.NewsItemByUser;
import by.mmf.yellowpress.thrift.gen.YellowPressErrorCode;
import by.mmf.yellowpress.thrift.gen.YellowPressException;
import by.mmf.yellowpress.thrift.gen.YellowPressService;
import by.mmf.yellowpress.utils.MappingUtil;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 12/10/14.
 */
public class YellowPressServiceImpl implements YellowPressService.Iface {

    private by.mmf.yellowpress.service.YellowPressService yellowPressService;

    public YellowPressServiceImpl() {
        yellowPressService = new by.mmf.yellowpress.service.impl.YellowPressServiceImpl();
    }

    @Override
    public void subscribe(String userId, String tag) throws YellowPressException, TException {
        yellowPressService.subscribe(userId, tag);
    }

    @Override
    public List<NewsItemByUser> getNewsByUser(String userId) throws YellowPressException, TException {
        List<NewsItemByUser> thriftResult = new ArrayList<>();
        List<by.mmf.yellowpress.domain.NewsItemByUser> result = yellowPressService.getNewsByUser(userId);
        for (by.mmf.yellowpress.domain.NewsItemByUser item : result) {
            NewsItemByUser thriftItem = new NewsItemByUser();
            try {
                MappingUtil.copyProperties(thriftItem, item);
            } catch (Exception e) {
                e.printStackTrace();
                throw new YellowPressException(YellowPressErrorCode.INTERNAL_ERROR, "conversion was failed.");
            }
            thriftResult.add(thriftItem);
        }
        return thriftResult;
    }
}
