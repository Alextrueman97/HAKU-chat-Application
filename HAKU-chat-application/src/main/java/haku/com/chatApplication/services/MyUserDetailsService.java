package haku.com.chatApplication.services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface MyUserDetailsService extends UserDetailsService {

	public void register(UserData user) throws UserAlreadyExistsException;
	public boolean checkIfUserExist(String username);
}
