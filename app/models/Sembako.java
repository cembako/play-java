package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sembakos")
public class Sembako extends Model {

	@Id
	public int id;

	public String name;

	@OneToMany(cascade = CascadeType.ALL)
	public List<SembakoPrice> prices;

	public static Finder<Integer, Sembako> find = new Finder<>(Integer.class, Sembako.class);

	public Sembako(){}
	public Sembako(String name){ this.name = name;}

	// public List<SembakoPrice> addPrice(){};
}