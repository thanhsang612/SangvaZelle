package love.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import love.entity.Image;
import love.entity.ImageForm;
import love.service.ImageService;


@Controller
public class ImageController {
	@Autowired 
	ImageService imageService;
	
	@RequestMapping("/nopaged")
	public String list(Model model) {
			List<Image> list = imageService.findAll();
			model.addAttribute("items", list);
		
		return "/home/index";
	}
	
	@GetMapping("/home")
	public ModelAndView listCustomers(Pageable pageable,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page){
//	    Page<Image> images = imageService.findAndPage(pageable);
	    Page<Image> images = imageService.findAndPage(PageRequest.of(page, 20,Sort.by("id").descending()));
	    ModelAndView modelAndView = new ModelAndView("/images/list");
	    modelAndView.addObject("images", images);
	    return modelAndView;
	}
	
	
	@RequestMapping("/create")
	  public String index(Model model) {
	    model.addAttribute("myFile", new ImageForm());
	    return "images/create";
	  }
	
	 @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	  public String uploadFile(ImageForm myFile, Model model) {
	    model.addAttribute("message", "Upload success");
	    model.addAttribute("description", myFile.getDescription());
	    model.addAttribute("id", myFile.getId());
	    try {
	      MultipartFile multipartFile = myFile.getImage();
	      String fileName = multipartFile.getOriginalFilename();
	      File file = new File(this.getFolderUpload(), fileName);
	      multipartFile.transferTo(file);
	      
	      Image i = new Image();
	      i.setId(myFile.getId());
	      i.setImage(fileName);
	      i.setDescription(myFile.getDescription());
	      imageService.save(i);
	    } catch (Exception e) {
	      e.printStackTrace();
	      model.addAttribute("message", "Upload failed");
	    }
	    return "images/result";
	  }
	 
	 public File getFolderUpload() {
		 	String u = "E:/Java6/SangZelle/uploads/images/";
		 	
		    File folderUpload = new File(u);
		    if (!folderUpload.exists()) {
		      folderUpload.mkdirs();
		    }
		    return folderUpload;
		  }
}


