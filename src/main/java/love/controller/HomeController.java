package love.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {

		return "redirect:/home";
	}
	
	@RequestMapping("/s")
	public String indexs(Model model) {

		return "redirect:/home";
	}
	
}
