package controllers;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		
	    return new Greeting(name, saudacao());
	}
	
	private String saudacao() {
		int data = LocalTime.now().getHour();
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
		
		return mensagem;
	}
 
}


class Greeting {
	
	String name;
	String greeting;
	
	public Greeting (String name, String greeting) {
		this.name = name;
		this.greeting = greeting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
}