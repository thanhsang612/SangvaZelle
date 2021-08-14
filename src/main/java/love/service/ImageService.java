package love.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import love.entity.Image;

public interface ImageService {

	List<Image> findAll();

	void save(Image image1);
	
	Page<Image> findAndPage(Pageable pageable);


}
