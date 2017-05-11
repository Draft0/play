package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Draft on 27.04.2017.
 */
@Entity
public class User extends Model {

    @Id
    public Long id;

    @Constraints.Required
    @Formats.NonEmpty
    @Column(unique = true)
    public String email;





    @Constraints.Required
    @Formats.NonEmpty
    public String passwordHash;

    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date dateCreation;



    // -- Queries (long id, user.class)
    public static Model.Finder<Long, User> find = new Model.Finder<Long, User>( Long.class, User.class );
}