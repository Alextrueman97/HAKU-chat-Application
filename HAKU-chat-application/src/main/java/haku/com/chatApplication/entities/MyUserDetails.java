package haku.com.chatApplication.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private UserAccount userAccount;
	
	public MyUserDetails(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(UserRole.USER.name()));
		if(userAccount.getRole() == UserRole.ADMIN) {
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.name()));
		}
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return userAccount.getPassword();
	}
	
	@Override
	public String getUsername() {
		return userAccount.getUsername();
	}
	
	public String getEmail() {
		return userAccount.getEmail();
	}
	
	public int getAccountId() {
		return userAccount.getAccountId();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
