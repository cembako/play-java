package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pantauans")
public class Pantauan extends Model {

	@Id
	public int id;

	public float price;

	@OneToOne(cascade = CascadeType.ALL)
	public Sembako sembako;

	@ManyToOne(cascade = CascadeType.ALL)
	public City city;

	@OneToOne(cascade = CascadeType.ALL)
	public List<Vote> votes;

	@ManyToOne(cascade = CascadeType.ALL)
	public User user;

    public static Finder<Integer, Pantauan> find = new Finder<>(Integer.class, Pantauan.class);

	public static List<Pantauan> getAll(){ return Pantauan.find.all() ;}
	
    public static List<Pantauan> byCity(City city){ return city.pantauans ;}

	public static List<Pantauan> byUser(User user){ return user.pantauans ;}

    int getScore(){ return 0; }
}
