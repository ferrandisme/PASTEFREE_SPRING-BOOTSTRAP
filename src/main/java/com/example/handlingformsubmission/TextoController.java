package com.example.handlingformsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TextoController {

	@GetMapping("/texto")
	public String textoForm(Model model) {
		model.addAttribute("texto", new Texto());
		return "texto";
	}

	@PostMapping("/texto")
	public String textoSubmit(@ModelAttribute Texto texto, Model model) {
		model.addAttribute("texto", texto);
		return "result";
	}

}
