package haku.com.chatApplication.entities;

import java.io.Serializable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserData implements Serializable {

	@NotEmpty(message = "Email can not be empty")
	@Email(message = "Please provide a valid email")
	private String email;
	
	@NotEmpty(message = "Password can not be empty")
	private String password;
	
	@NotEmpty(message = "Username can not be empty")
	private String username;
	
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
