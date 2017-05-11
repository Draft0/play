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
    public Integer id;

    @Constraints.Required
    @Formats.NonEmpty
    public String email;

    @Constraints.Required
    @Formats.NonEmpty
    public String password;

    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date date;

    public User(Integer id, String email, String password, Date date) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}