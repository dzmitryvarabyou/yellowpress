package by.mmf.yellowpress.service;

import by.mmf.yellowpress.domain.NewsItemByUser;
import by.mmf.yellowpress.domain.NewsItem;

import java.util.List;

/**
 * Represents main service interface which provides operations like: subscribing, getting news by tags & faculties,
 * adding new news item etc.
 *
 * @author dvarabyou
 */
public interface YellowPressService {

    void subscribe(String usedId, String tag);

    List<NewsItemByUser> getNewsByUser(String userId);

    List<NewsItemByUser> getNewsByUserAndTag(String userId, String tag);

    List<NewsItemByUser> getNewsByUserAndFaculty(String userId, String faculty);

    List<NewsItemByUser> getNewsPreviewsByTag(String tag);

    List<NewsItemByUser> getNewsPreviewsByFaculty(String faculty);

    void addNewsItem(NewsItem newsItem);

    NewsItem getNewsItemById(String newsId);

    List<NewsItem> getAllNewsItems();

    List<NewsItem> getAllNewsPreviews();

}
