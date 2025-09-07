package com.example.prism2;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;

	@Column(unique = true , nullable = false)
	private String email;

	@Column(name="google_id" , unique = true)
	private String googleId;

	@Column(name="email_verified_at")
	private Instant emailVerifiedAt;

	private String password;
	
	@Column(name = "verification_code")
	private String verificationCode;
	
	@Column(name = "verification_code_sent_at")
	private Instant verificationCodeSentAt;
	
	private String bio; 
	
	@Column(name = "is_private")
	private Boolean isPrivate = false;

	// this column would be saving json ( but java does not support that as a type so we save it as a string and then map that string to a json in the DB)
	@Column(name = "personal_info" , columnDefinition = "jsonb")
	private String personalInfo;
	
	@Column(name = "device_token")
	private String deviceToken;
	
	@Column(name = "remember_token")
	private String rememberToken;

	@Column(name="created_at",updatable = false)
	private Instant createdAt;

	@Column(name="updated_at")
	private Instant updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = Instant.now();
		this.updatedAt = Instant.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = Instant.now();
	}
}
