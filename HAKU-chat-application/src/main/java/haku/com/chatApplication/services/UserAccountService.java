package haku.com.chatApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public UserAccount updateUser(UserAccount userAccount) {
		return userAccountRepository.save(userAccount);
	}
	
	@Override
	public Optional<UserAccount> findUserByUserId(int accountId){
		return userAccountRepository.findById(accountId);
	}
}
