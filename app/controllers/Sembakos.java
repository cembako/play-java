package controllers;

import com.google.gson.Gson;
import models.City;
import models.JsonSembako;
import models.SembakoPrice;
import play.mvc.*;
import static play.libs.Json.*;
import models.Sembako;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Sembakos extends Controller
{
    public static Result getLoadData()  throws IOException {
        //System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
        String json = new String(Files.readAllBytes(Paths.get("2015-02.json")), StandardCharsets.UTF_8);
        JsonSembako[] jsonSembakos=  new Gson().fromJson(json, JsonSembako[].class);
        City jogja = new City();
        jogja.name= "Yogyakarta";
        jogja.save();

        Arrays.stream(jsonSembakos).forEach(jsonSembako -> {
            Sembako sembako = new Sembako(jsonSembako.name);
            sembako.save();

            jsonSembako.prices.forEach((key, value) -> {
                SembakoPrice price = new SembakoPrice();
                price.city = jogja;
                price.date = new Date(2015,2,key);
                price.price = value;
                price.sembako=sembako;
                price.save();
            });
        });
        return ok("Data should be loaded now.");
    }

    public static Result index(){
        List<Sembako> sembakos = Sembako.find.all();
    	return ok( toJson(sembakos) );
    }

    public static Result show(int id){
        if (id == 0) return badRequest("Wrong ID");

        Sembako sembako = Sembako.find.byId(id);
        return ok( toJson(sembako) );
    }
}
