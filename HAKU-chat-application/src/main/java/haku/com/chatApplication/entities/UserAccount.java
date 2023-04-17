package haku.com.chatApplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_account")
public class UserAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String avatarUrl;
    
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

	public UserAccount() {
		super();
	}

	public UserAccount(int accountId, String username, String email, String password, String avatarUrl) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.avatarUrl = avatarUrl;
	}
	
	public UserAccount(int accountId, String username, String email, String password, String avatarUrl, UserRole role) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.avatarUrl = avatarUrl;
		this.role = role;
	}

	public UserAccount(String username, String email, String password, UserRole role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public UserAccount(String email, String password) {
		super();
		this.email = email;
		this.password =  password;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	
	
}