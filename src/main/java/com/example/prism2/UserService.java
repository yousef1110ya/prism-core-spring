package com.example.prism2;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User registerUser(String email , String password) {
		User user = new User();
	
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		
		return userRepository.save(user);
	}

	public String generateVerificationCode() {
		byte[] randomBytes = new byte[24];
		new SecureRandom().nextBytes(randomBytes);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
	}
}
