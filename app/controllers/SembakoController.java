package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;
import play.db.ebean.Model;
import static play.libs.Json.*;
import views.html.*;
import models.User;
import java.util.List;

public class SembakoController extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result addUser() {
    	User User = Form.form(User.class).bindFromRequest().get();
    	User.save();
    	return redirect(routes.Application.index());
    }

    public static Result getUsers() {
    	List<User> users = new Model.Finder(String.class, User.class).all();
    	return ok(toJson(users));
    }
}
