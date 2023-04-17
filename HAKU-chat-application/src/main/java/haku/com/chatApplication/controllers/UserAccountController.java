package haku.com.chatApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import haku.com.chatApplication.entities.MyUserDetails;
import haku.com.chatApplication.entities.UserData;
import haku.com.chatApplication.services.MyUserDetailsService;
import haku.com.chatApplication.services.UserAccountService;
import haku.com.chatApplication.services.UserAlreadyExistsException;

@Controller
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userData", new UserData());
		return "register";
	}
	
	@PostMapping("/register")
	public String userRegistration(UserData userData, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("userData", userData );
			model.addAttribute("error", bindingResult.getFieldError().getDefaultMessage());
			return "register";
		}
		try {
			userDetailsService.register(userData);
		} catch(UserAlreadyExistsException e) {
			bindingResult.rejectValue("email", "userData.email", "An account already exists for this email.");
			model.addAttribute("error", bindingResult.getFieldError().getDefaultMessage());
			model.addAttribute("userData", userData);
			return "register";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
	
	@GetMapping("/account")
	public String account(Model model, @AuthenticationPrincipal MyUserDetails user) {
		model.addAttribute("accountId", user.getAccountId());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("role", user.getRole());
		model.addAttribute("avatar", user.getAvatarUrl());
		return "/account";
	}
	
}
