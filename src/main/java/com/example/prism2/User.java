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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public Instant getEmailVerifiedAt() {
		return emailVerifiedAt;
	}

	public void setEmailVerifiedAt(Instant emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Instant getVerificationCodeSentAt() {
		return verificationCodeSentAt;
	}

	public void setVerificationCodeSentAt(Instant verificationCodeSentAt) {
		this.verificationCodeSentAt = verificationCodeSentAt;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
