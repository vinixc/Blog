package br.com.blueclover.blog.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.blueclover.blog.entity.Autor;
import br.com.blueclover.blog.service.AutorService;

@Controller
@RequestMapping("autor")
public class AutorController {

	private static final Logger LOG = Logger.getLogger(AvatarController.class);
	
	@Autowired
	private AutorService autorService;
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		autorService.delete(id);
		
		return "redirect:/autor/add";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView preUpdate(@PathVariable("id") Long id) {
		
		ModelAndView view = new ModelAndView();
		
		Autor autor = autorService.findById(id);
		
		view.addObject("autor", autor);
		view.setViewName("autor/cadastro");
		
		return view;
	}
	
	@RequestMapping(value = {"/perfil/{id}","/list"}, method = RequestMethod.GET)
	public ModelAndView getAutor(@PathVariable("id") Optional<Long> id) {
		ModelAndView view = new ModelAndView("autor/perfil");
		
		if(id.isPresent()) {
			Autor autor = autorService.findById(id.get());
			view.addObject("autores", Arrays.asList(autor));
		}else {
			List<Autor> autores = autorService.findAll();
			view.addObject("autores", autores);
		}
		
		return view;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("autor") Autor autor) {
		autorService.save(autor);
		return "redirect:/autor/perfil/" + autor.getId();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addAutor(@ModelAttribute("autor") Autor autor) {
		return new ModelAndView("autor/cadastro");
	}
	
	

}
