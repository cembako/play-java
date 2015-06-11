package controllers;

import models.Pantauan;
import play.mvc.*;
import static play.libs.Json.*;

import java.io.IOException;
import java.util.List;

public class Pantauans extends Controller
{
    public static Result index(){
        List<Pantauan> pantauans = Pantauan.find.all();
        return ok( toJson(pantauans) );
    }
    public static Result create(){
        Pantauan pantauan = new Pantauan();
        pantauan.save();
        return ok( toJson(pantauan) );
    }
}
