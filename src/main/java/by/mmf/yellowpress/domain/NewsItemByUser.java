package by.mmf.yellowpress.domain;

import com.netflix.astyanax.annotations.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @Component(ordinal = 0)
    public String userId;
    @Component(ordinal = 1)
    public String tag;
    @Component(ordinal = 2)
    public Date publishedAt;
    @Component(ordinal = 3)
    public String newsId;
    public String title;
    public String description;
    public String imageUrl;
    public String faculty;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

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
