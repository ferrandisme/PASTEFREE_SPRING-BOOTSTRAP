package com.example.handlingformsubmission.api;

import com.example.handlingformsubmission.model.Texto;
import com.example.handlingformsubmission.service.TextoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class TextoController {

	private final TextoService textoService;

	@Autowired
	public TextoController(TextoService textoService){this.textoService = textoService;}


	@GetMapping("/texto")
	public String textoForm(Model model) {
		model.addAttribute("texto", new Texto());
		return "texto";
	}

	@PostMapping("/texto")
	public String textoSubmit(@ModelAttribute Texto texto, Model model) {
		model.addAttribute("texto", texto);
		return texto.getId() + "";
	}

	@GetMapping(path = "texto/{id}")
	public Texto getPersonById(@PathVariable("id") int id){
		return textoService.getTextoById(id)
				.orElse(null);
	}

}
