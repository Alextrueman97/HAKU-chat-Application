package haku.com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "blocked_user")
public class BlockedUser 
{
	private String email;

	public BlockedUser() {
		super();
	}

	public BlockedUser(String email) {
		super();
		this.email = email;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
