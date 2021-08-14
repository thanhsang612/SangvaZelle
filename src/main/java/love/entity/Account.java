package love.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "account")
public class Account implements Serializable{
	@Id
	Integer id;
	String username;
	String password;
	String role;
}
