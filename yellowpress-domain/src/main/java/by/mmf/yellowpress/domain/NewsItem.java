package by.mmf.yellowpress.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * An entity which represents an entire news item.
 *
 * @author dvarabyou
 */
public class NewsItem implements Serializable{

    public String newsId;
    public Date publishedAt;
    public Date lastModifiedAt;
    public String faculty;
    public String title;
    public String body;
    public String description;
    public String imageUrl;
    public List<String> tags;

    @Override
    public String toString() {
        return "NewsItem{" +
                "newsId='" + newsId + '\'' +
                ", publishedAt=" + publishedAt +
                ", lastModifiedAt=" + lastModifiedAt +
                ", faculty='" + faculty + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tags=" + tags +
                '}';
    }
}
