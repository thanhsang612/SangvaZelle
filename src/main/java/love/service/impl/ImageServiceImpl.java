package love.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import love.dao.ImageDao;
import love.entity.Image;
import love.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	ImageDao dao;

	@Override
	public List<Image> findAll() {
	
		return dao.findAll();
	}

	@Override
	public void save(Image image1) {
		dao.save(image1);
		
	}

	@Override
	public Page<Image> findAndPage(Pageable pageable) {

		return dao.findAll(pageable);
	}
	
	
}
