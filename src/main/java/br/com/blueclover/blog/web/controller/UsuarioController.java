package br.com.blueclover.blog.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.blueclover.blog.entity.Avatar;
import br.com.blueclover.blog.entity.Perfil;
import br.com.blueclover.blog.entity.Usuario;
import br.com.blueclover.blog.service.AvatarService;
import br.com.blueclover.blog.service.UsuarioService;
import br.com.blueclover.blog.web.editor.PerfilEditorSupport;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AvatarService avatarService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Perfil.class, new PerfilEditorSupport());
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUsuarios(ModelMap model) {
		
		List<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios", usuarios);
		
		return new ModelAndView("usuario/list", model);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public ModelAndView perfil(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView();
		
		Usuario usuario = usuarioService.findById(id);
		
		view.addObject("usuario", usuario);
		view.setViewName("usuario/perfil");
		return view;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("usuario") Usuario usuario,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		
		Avatar avatar = avatarService.getAvatarByUpload(file);
		usuario.setAvatar(avatar);
		
		usuarioService.save(usuario);
		
		return "redirect:/usuario/perfil/" + usuario.getId();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm(@ModelAttribute("usuario") Usuario usuario) {
		return new ModelAndView("usuario/cadastro");
	}
}
