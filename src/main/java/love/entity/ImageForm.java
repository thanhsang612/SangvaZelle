package love.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class ImageForm implements Serializable{
	@Id
	Integer id;
	String description;
	MultipartFile  image;
}
