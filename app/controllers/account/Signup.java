package controllers.account;

import controllers.HomeController;
import models.User;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.account.signup.created;

import static play.data.Form.form;

/**
 * Created by Draft on 25.05.2017.
 */
public class Signup extends Controller {

    public Result create() {
        return ok(create.render(form( HomeController.Register.class)));
    }

    public Result createFormOnly() {
        return ok(create.render(form( HomeController.Register.class)));
    }

    public Result save() {
        Form<HomeController.Register> registerForm = form(HomeController.Register.class).bindFromReguest();

        if (registerForm.hasErrors()) {
            return badRequest(create.render(registerForm));
        }

        HomeController.Register register = registerForm.get();
        Result resultError = checkBeforeSave(registerForm, register.email);

        if (resultError != null) {
            return resultError;
        }

        try {
            User user = new User();
            user.email = register.email;
            user.fullname = register.fullname;
            user.password = register.inputPassword;

            user.save();

            return ok( created.render());
        } catch (Exception e) {
            Logger.error( "Signup save error", e );
            flash("error");
        }
       return badRequest(create.render(registerForm));
    }

}
