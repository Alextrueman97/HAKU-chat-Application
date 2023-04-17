package haku.com.chatApplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haku.com.chatApplication.entities.UserAccount;
import haku.com.chatApplication.repositories.UserAccountRepository;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	public UserAccount register(UserAccount userAccount) {
		return userAccountRepository.save(userAccount);
	}
	
	public UserAccount login(String email, String password) {
		return userAccountRepository.login(email, password);
	}
	
	public UserAccount updateUser(UserAccount userAccount) {
		return userAccountRepository.save(userAccount);
	}
	
	public Optional<UserAccount> findUserByUserId(int accountId){
		return userAccountRepository.findById(accountId);
	}
}
