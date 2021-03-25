package com.cars.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cars.test.entity.Car;
import com.cars.test.repository.CarRepository;

@Controller
public class UserController {

	@Autowired
	private CarRepository carRepository;

//	@RequestMapping(value = "{path:.*}")
	@GetMapping(value="")
	public String index() {
		return "index";
	}

	@GetMapping("/signup")
	public String showSignUpForm(Car user) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid Car user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		} else {

			carRepository.save(user);
			return "redirect:/index";
		}
	}

	@GetMapping({"/index", "/", ""})
	public String showUserList(Model model) {
		model.addAttribute("users", carRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Car user = carRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("car", user);
		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Car user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		carRepository.save(user);
		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Car user = carRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		carRepository.delete(user);
		return "redirect:/index";
	}
	
	@GetMapping("/login")
	public String getLoginView() {
		return "login"; // must match login.html
	}
	
	@GetMapping("/logout")
	public String getLogoutView() {
		return "logout"; // must match login.html
	}

}
