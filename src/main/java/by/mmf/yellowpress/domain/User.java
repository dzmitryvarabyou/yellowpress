package by.mmf.yellowpress.domain;

import com.netflix.astyanax.annotations.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Represents user account.
 */
public class User implements Serializable {

    public String userId;
    public String userEmail;
    public String userPass;
    public List<String> subscribedTags;
    public List<String> subscribedFaculties;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPass='" + userPass + '\'' +
                ", subcribedTags=" + subscribedTags +
                ", subcribedFaculties=" + subscribedFaculties +
                '}';
    }
}
