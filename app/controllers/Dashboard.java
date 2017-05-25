package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import views.html.dashboard.index;
import static models.User.findByEmail;

/**
 * Created by Draft on 25.05.2017.
 */
@Security.Authenticated(Secured.class)
public class Dashboard extends Controller {

    public Result index() {
        return ok( index.render( findByEmail( request().username() )));
    }
}
