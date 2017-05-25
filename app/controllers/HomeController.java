package controllers;

import models.User;
import models.utils.AppException;
import play.Logger;
import play.data.Form;
import play.data.validation.Constraints;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import static play.data.Form.form;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    public static Result GO_HOME = redirect(
            routes.HomeController.index()
    );

    public static Result GO_DASHBOARD = redirect(
            routes.HomeController.index()
    );

    public Result index() {
        String email = ctx().session().get( "email" );
        if (email != null) {
            User user = User.findByEmail( email );
        } else  {
            Logger.debug("error");
            session().clear();
        }
        return ok(index.render(form(Register.class), form(Login.class)));
    }

    public static class Login {

        @Constraints.Required
        public String email;
        @Constraints.Required
        public String password;

        public String validate() {

            User user = null;
            try {
                user = User.authenticate(email, password);
            } catch (Exception e) {
                return Messages.get("error.technical");
            }


                return null;
            }
        }


    public static class Register {

        @Constraints.Required
        public String email;

        @Constraints.Required
        public String fullname;

        @Constraints.Required
        public String inputPassword;

        public String validate() {
            if (isBlank(email)) {
                return "Email is required";
            }

            if (isBlank(fullname)) {
                return "Full name is required";
            }

            if (isBlank(inputPassword)) {
                return "Password is required";
            }

            return null;
        }

        private boolean isBlank(String input) {
            return input == null || input.isEmpty() || input.trim().isEmpty();
        }
    }



    public Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromReguest();

        Form<Register> registerForm = form(Register.class);

        if (loginForm.hasErrors()) {
            return badRequest(index.render(registerForm, loginForm));
        } else {
           session("email", loginForm.get().email);
           return GO_DASHBOARD;
        }
    }

    public Result logout() {

        session().clear();
        flash("success");
        return GO_HOME;
    }
}
