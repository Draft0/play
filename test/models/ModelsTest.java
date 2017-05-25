package models;

import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.*;
/**
 * Created by Draft on 22.05.2017.
 */
public class ModelsTest extends WithApplication {

    @Before
    public void setUp() {
        start( fakeApplication(inMemoryDatabase()));

    }


    @Test
    public void createAndRetriveUser() {
        new User( "bob@gmail.com", "Bob", "123" ).save();
        User bob = User.find.where().eq( "email", "bob@gmail.com" ).findUnique();
        assertNotNull(bob);
        assertEquals("Bob", bob.name);

    }
}
