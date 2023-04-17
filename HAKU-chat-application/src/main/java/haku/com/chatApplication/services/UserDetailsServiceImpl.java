package haku.com.chatApplication.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements MyUserDetailsService {

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount user = userAccountRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);
	}

	@Override
	public void register(UserData user) throws UserAlreadyExistsException {
		//method to register but check if User already exists
		if (checkIfUserExis(user.getEmail())) {
			throw new UserAlreadyExistsException("User already exists for this email");
		}
		UserAccount userEntity = new UserAccount();
		BeanUtils.copyProperties(user,  userEntity);
		encodePassword(userEntity, user);
		userAccountRepository.save(userEntity);
		
	}

	@Override
	public boolean checkIfUserExist(String emailAddress) {
		return userAccountRepository.findByEmailAddress(emailAddress) != null ? true : false;
	}
	
	private void encodePassword(UserAccount userEntity, UserData user) {
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
	}
	
}
