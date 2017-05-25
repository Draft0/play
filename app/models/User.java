package models;

import com.avaje.ebean.Model;
import models.utils.AppException;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Draft
 */

@Entity
public class User extends Model {

    private static final int EXPIRATION_DAYS = 1;

    @Id
    public Long id;

    @Constraints.Required
    @Formats.NonEmpty
    @Column(unique = true)
    public String email;

    @Constraints.Required
    @Formats.NonEmpty
    @Column(unique = true)
    public String fullname;

    @Constraints.Required
    @Formats.NonEmpty
    public String password;

    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date dateCreation;

public static Model.Finder<Long, User> find = new Model.Finder<Long, User>(Long.class, User.class);

public static User findByEmail(String email) {
    return find.where().eq( "email", email ).findUnique();
}

public static User findByFullname(String fullname) {
    return find.where().eq( "fullname", fullname ).findUnique();
}

public boolean isExpired() {
    return dateCreation != null && dateCreation.before( expirationTime() );
}

private Date expirationTime() {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.DATE, -EXPIRATION_DAYS);
    return  cal.getTime();
}

    public static User authenticate(String email, String clearPassword) throws AppException {

        // get the user with email only to keep the salt password
        User user = find.where().eq("email", email).findUnique();
        if (user != null) {
            // get the hash password from the salt + clear password

                return user;

        }
        return null;
    }


public static boolean confirm(User user) {
    if (user == null) {
        return false;
    }
    user.save();
    return  true;
}





}
