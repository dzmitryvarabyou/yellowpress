package by.mmf.yellowpress.thrift.impl;

import by.mmf.yellowpress.service.YellowPressService;
import by.mmf.yellowpress.thrift.*;
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
                MappingUtil.copyProperties(thriftItem, item);
            } catch (Exception e) {
                e.printStackTrace();
                throw new YellowPressExceptionT(YellowPressErrorCodeT.INTERNAL_ERROR, "conversion was failed.");
            }
            thriftResult.add(thriftItem);
        }
        return thriftResult;
    }

    @Override
    public List<String> getAllSubscribedTags(String userId) throws YellowPressExceptionT, TException {
        return yellowPressService.getAllSubscribedTags(userId);
    }

    @Override
    public void removeSubscription(String userId, String tag) throws YellowPressExceptionT, TException {
        yellowPressService.removeSubscription(userId, tag);
    }

    @Override
    public List<NewsItemT> getAllNewsPreviews() throws YellowPressExceptionT, TException {
        List<NewsItemT> thriftResult = new ArrayList<NewsItemT>();
        List<by.mmf.yellowpress.domain.NewsItem> result = yellowPressService.getAllNewsPreviews();
        for (by.mmf.yellowpress.domain.NewsItem item : result) {
            NewsItemT thriftItem = new NewsItemT();
            try {
                MappingUtil.copyProperties(thriftItem, item);
            } catch (Exception e) {
                e.printStackTrace();
                throw new YellowPressExceptionT(YellowPressErrorCodeT.INTERNAL_ERROR, "conversion was failed.");
            }
        }
        return thriftResult;
    }

    @Override
    public List<NewsItemT> getNewsPreviewsByFacultyAndTags(String faculty, List<String> tags) throws YellowPressExceptionT, TException {
        return null;
    }

    @Override
    public NewsItemT getNewsItem(String newsItemId) throws YellowPressExceptionT, TException {
        NewsItemT thriftResult = new NewsItemT();
        by.mmf.yellowpress.domain.NewsItem result = yellowPressService.getNewsItemById(newsItemId);
        try {
            MappingUtil.copyProperties(thriftResult, result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new YellowPressExceptionT(YellowPressErrorCodeT.INTERNAL_ERROR, "conversion was failed.");
        }
        return thriftResult;
    }
}
