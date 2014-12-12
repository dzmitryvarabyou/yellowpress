package by.mmf.yellowpress.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * An entity which represents an news items for the given user.
 * <p/>
 * Used to perform read operations for particular user such as:
 * fetching some news information for the given user, it means only parts of news
 * for which user was subscribed etc.
 *
 * @author dvarabyou
 */
public class NewsItemByUser implements Serializable {

    public String userId;
    public String tag;
    public Date publishedAt;
    public String newsId;
    public String title;
    public String description;
    public String imageUrl;
    public String faculty;

    @Override
    public String toString() {
        return "NewsByUser{" +
                "userId='" + userId + '\'' +
                ", newsId='" + newsId + '\'' +
                ", publishedAt=" + publishedAt +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", faculty='" + faculty + '\'' +
                ", tags=" + tag +
                '}';
    }
}
