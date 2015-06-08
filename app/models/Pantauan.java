package models;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import models.Pantauan;
import java.util.List;

@Entity
@Table(name = "pantauans")
public class Pantauan extends Model {

	@Id
	public int id;

	public float price;
	public Sembako sembako;
	public City city;
	//public Vote[] votes;
	
    public static Finder<Integer, Pantauan> find = new Finder<>(Integer.class, Pantauan.class);

	List<Pantauan> getAll(){ return Pantauan.find.all() ;}
	
    //List<Pantauan> byCity(){ return Pantauan.find.all() ;}
    
    //List<Pantauan> byUser(){ return Pantauan.find.all() ;}
    
    //int getScore(){ return 0; }

}