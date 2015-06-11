package controllers;

import com.google.gson.Gson;
import play.mvc.*;
import static play.libs.Json.*;
import models.Sembako;
import models.SembakoPrice;

import java.util.List;

public class SembakoPrices extends Controller
{
    public static Result index(){
        List<SembakoPrice> prices = SembakoPrice.find.all();
    	return ok( toJson(prices) );
    }

    public static Result show(int id){
        if (id == 0) return badRequest("Wrong ID");

        SembakoPrice price = SembakoPrice.find.byId(id);
        return ok( toJson(price) );
    }
}
