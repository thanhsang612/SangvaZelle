package love.dao;




import org.springframework.data.jpa.repository.JpaRepository;



import love.entity.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	
}
