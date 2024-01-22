package com.example.app.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignController {
	private final UserRepository userRepository;

	@GetMapping("/signin")
	public String showSignin() {
		return "signin";
	}

	@PostMapping("/signin")
	public String proceedSignin(User user, HttpSession session, Model model) {
		// database에서 유저 찾고
		User foundUser = userRepository.findById(user.getId());
		// 없으면
		if (foundUser == null) {
			// return "redirect:/signin";
			model.addAttribute("error", true);
			return "signin";
		}
		// 있다면..
		// 비밀번호 일치확인 (암호화가 되있기때문에 equals 로 비교 안됨)
		System.out.println(user);
		if (BCrypt.checkpw(user.getPassword(), foundUser.getPassword())) {
			session.setAttribute("logonUser", foundUser);
			return "redirect:/index";
		} else {
			// 그렇지않으면 다시 id,password 치는 곳으로 리다이렉트 시키거나.
			// return "redirect:/signin";
			model.addAttribute("error", true);
			return "signin";
		}
	}
}
