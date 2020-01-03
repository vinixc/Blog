package br.com.blueclover.blog.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.blueclover.blog.entity.Postagem;
import br.com.blueclover.blog.service.PostagemService;

@Controller
public class HomeController {
	
	@Autowired
	private PostagemService postagemService; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model) {
		
		List<Postagem> postagens = postagemService.findAll();
		
		model.addAttribute("postagens", postagens);
		
		return new ModelAndView("posts", model);
	}

}
