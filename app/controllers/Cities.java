package controllers;

import models.City;
import models.Pantauan;
import play.mvc.*;
import static play.libs.Json.*;
import java.util.List;

public class Cities extends Controller
{
    public static Result index(){
        List<City> cities = City.find.all();
        return ok( toJson(cities) );
    }    
}
