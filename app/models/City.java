package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cities")
public class City extends Model {

	@Id
	public int id;

	public String name;

	@OneToMany
	List<Pantauan> pantauans;
	
	public static Finder<Integer, City> find = new Finder<>(Integer.class, City.class);

	public List<Sembako> getSembakos(){
		return Sembako.find
				.select("*")
				.fetch("sembako_prices")
				.where()
				.eq("sembako_prices.city_id", this.id).findList();
	}

	public List<Pantauan> getPantauans(){ return this.pantauans; }
}