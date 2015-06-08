package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;
import play.data.validation.Constraints;
import models.Pantauan;

@Entity
@Table(name = "users")
public class User extends Model {

	@Id
	public long id;

	@Column(unique = true)
	public String name;

	public String fullname;
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	public List<Pantauan> pantauans;

	@Constraints.Email
	@Column(unique = true)
	public String email;
	
	public static Finder<Long, User> find = new Finder<>(Long.class, User.class);

	public Pantauan createPantauan(){
		Pantauan pantauan=new Pantauan();
		pantauan.price=10000;
		pantauan.sembako=Sembako.find.byId(1);
		pantauan.city=City.find.byId(1);
		return pantauan;
	}

	public Pantauan upvotePantauan(int pantauan_id){
		Pantauan pantauan=Pantauan.find.byId(pantauan_id);
		Vote vote = new Vote();
		vote.score=1;
		vote.user=this;
		vote.pantauan=pantauan;
		vote.save();
		return pantauan;
	}
	public Pantauan downvotePantauan(int pantauan_id){
		Pantauan pantauan=Pantauan.find.byId(pantauan_id);
		Vote vote = new Vote();
		vote.score=-1;
		vote.user=this;
		vote.pantauan=pantauan;
		vote.save();
		return pantauan;
	}

	// public List<String> seeNews(){}
	public List<Sembako> seeSembakos(){
	    return Sembako.find.all();
	}
	public List<Pantauan> seePantauans(){
		return Pantauan.find.all();
	}
}