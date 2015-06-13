package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.FetchConfig;
import play.*;
import play.mvc.*;
import play.data.Form;
import static play.libs.Json.*;
import views.html.*;
import models.*;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import com.google.gson.Gson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result addUser() {
    	User user = Form.form(User.class).bindFromRequest().get();
    	user.save();
    	return redirect(routes.Application.index());
    }

    public static Result getUsers() {
    	List<User> users = User.find.all();
    	return ok(toJson(users));
    }
}
