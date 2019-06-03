package controllers;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		int data = LocalTime.now().getHour();
		model.addAttribute("name", name);
		String mensagem = "";
		
		if (data > 18 && data <= 23) {
			mensagem = "boa noite";
		}
		else if (data >= 0 && data < 12) {
			mensagem = "bom dia";
		}
		else {
			mensagem = "boa tarde";
		}
		
		model.addAttribute("mensagem", mensagem);
		return "hello";
	}
	
}

