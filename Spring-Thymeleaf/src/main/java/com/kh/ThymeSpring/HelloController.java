package com.kh.ThymeSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

		@GetMapping("/hello")
		public String hello(Model model) {
			model.addAttribute("message", "I am 타임리프예요.");
			return "HELLO";
		}
}
