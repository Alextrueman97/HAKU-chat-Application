package haku.com.chatApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blocked_user")
public class BlockedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blockedId;
    
	private String email;

	public BlockedUser() {
		super();
	}

	public BlockedUser(int blockedId, String email) {
		super();
		this.blockedId = blockedId;
		this.email = email;
	}

	public int getBlockedId() {
		return blockedId;
	}

	public void setBlockedId(int blockedId) {
		this.blockedId = blockedId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
