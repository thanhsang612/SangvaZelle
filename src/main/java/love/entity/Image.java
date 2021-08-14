package love.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "image")
public class Image implements Serializable{
	@Id
	Integer id;
	String image;
	String description;
}
