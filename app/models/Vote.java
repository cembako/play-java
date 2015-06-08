package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote extends Model {

	@Id
	public long id;

	User user;
    Pantauan pantauan;
    byte score;
}