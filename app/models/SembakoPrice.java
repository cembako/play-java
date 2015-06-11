package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sembako_prices")
public class SembakoPrice extends Model {

	@Id
	@JsonIgnore
	public int id;

	@ManyToOne
	@JsonIgnore
	public Sembako sembako;

	@ManyToOne(cascade = CascadeType.ALL)
	public City city;

	public float price;

	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date date;
	
	public static Finder<Integer, SembakoPrice> find = new Finder<>(Integer.class, SembakoPrice.class);
}