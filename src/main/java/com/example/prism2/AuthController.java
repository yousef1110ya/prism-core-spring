package com.example.prism2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

record RegisterRequest(String email , String password) {}
record RegisterResponse(String verificationCode) {}

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserService userService;
	public AuthController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
	
		User user = userService.registerUser(request.email(), request.password());
		return ResponseEntity.ok(new RegisterResponse(user.getVerificationCode()));
	}
}
