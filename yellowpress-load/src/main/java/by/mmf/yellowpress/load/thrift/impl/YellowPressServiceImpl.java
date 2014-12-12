package by.mmf.yellowpress.load.thrift.impl;

import by.mmf.yellowpress.domain.NewsItemByUser;
import by.mmf.yellowpress.service.YellowPressService;
import by.mmf.yellowpress.thrift.NewsItemByUserT;
import by.mmf.yellowpress.thrift.YellowPressErrorCodeT;
import by.mmf.yellowpress.thrift.YellowPressExceptionT;
import by.mmf.yellowpress.thrift.YellowPressServiceT;
import by.mmf.yellowpress.utils.MappingUtil;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dvarabyou
 */
public class YellowPressServiceImpl implements YellowPressServiceT.Iface {

    private YellowPressService yellowPressService;

    public YellowPressServiceImpl() {
        yellowPressService = new by.mmf.yellowpress.service.impl.YellowPressServiceImpl();
    }

    @Override
    public void subscribe(String userId, String tag) throws YellowPressExceptionT, TException {
        yellowPressService.subscribe(userId, tag);
    }

    @Override
    public List<NewsItemByUserT> getNewsByUser(String userId) throws YellowPressExceptionT, TException {
        List<NewsItemByUserT> thriftResult = new ArrayList<NewsItemByUserT>();
        List<by.mmf.yellowpress.domain.NewsItemByUser> result = yellowPressService.getNewsByUser(userId);
        for (by.mmf.yellowpress.domain.NewsItemByUser item : result) {
            NewsItemByUserT thriftItem = new NewsItemByUserT();
            try {
                copyProperties(thriftItem, item);
            } catch (Exception e) {
                e.printStackTrace();
                throw new YellowPressExceptionT(YellowPressErrorCodeT.INTERNAL_ERROR, "conversion was failed.");
            }
            thriftResult.add(thriftItem);
        }
        return thriftResult;
    }

    public static void copyProperties(NewsItemByUserT dest, NewsItemByUser orig) {
        dest.userId = orig.userId;
        dest.tag = orig.tag;
        dest.publishedAt = orig.publishedAt.toString();
        dest.newsId = orig.newsId;
        dest.title = orig.title;
        dest.description = orig.description;
        dest.imageUrl = orig.imageUrl;
        dest.faculty = orig.faculty;
    }
}
