package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City extends Model {

	@Id
	public int id;

	public String name;

	public City(){}
	public City(String cityName) { this.name=cityName; }
	
	public static Finder<Integer, City> find = new Finder<>(Integer.class, City.class);
}