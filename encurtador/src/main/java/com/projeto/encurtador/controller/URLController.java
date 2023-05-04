package com.projeto.encurtador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.projeto.encurtador.entity.URL;
import com.projeto.encurtador.repository.URLRepository;

@Controller
public class URLController {

	@Autowired
	private URLRepository urlRepository;
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
		
	@PostMapping("/salvar")
	public String salvar(URL url, Model model) {
		System.out.println(url.getUrlOriginal());
		urlRepository.save(url);
		
		StringBuilder builder = new StringBuilder();
		builder.append("localhost:8081/url/");
		builder.append(url.getId());
		
		model.addAttribute("link", builder.toString());
		return "resultado";
	}
	
	@GetMapping("/url/{id}")
	public RedirectView redirect(@PathVariable(value="id") int id ) {
		RedirectView redirector = new RedirectView();
		Optional<URL> url = urlRepository.findById(id);
		redirector.setUrl(url.get().getUrlOriginal());
		return redirector;
	}
	
	@GetMapping("/resultado")
	public String resultado() {
		return "resultado";
	}
	
}
