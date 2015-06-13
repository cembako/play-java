package models;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import javax.persistence.*;

import models.Pantauan;
import java.util.List;

@Entity
@Table(name = "pantauans")
public class Pantauan extends Model {

	@Id
	public int id;

	public float price;
	public Sembako sembako;

	@ManyToOne(cascade = CascadeType.ALL)
	public City city;

	//public Vote[] votes;

	@ManyToOne(cascade = CascadeType.ALL)
	public User user;
	
    public static Finder<Integer, Pantauan> find = new Finder<>(Integer.class, Pantauan.class);

	public static List<Pantauan> getAll(){ return Pantauan.find.all() ;}
	
    public static List<Pantauan> byCity(City city){ return city.pantauans ;}

	public static List<Pantauan> byUser(User user){ return user.pantauans ;}
    
    int getScore(){ return 0; }

}