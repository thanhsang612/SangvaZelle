package love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class SangxZelleFinalApplication extends  SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SangxZelleFinalApplication.class, args);
	}

}
