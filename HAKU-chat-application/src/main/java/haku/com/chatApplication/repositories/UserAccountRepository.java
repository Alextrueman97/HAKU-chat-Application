package haku.com.chatApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import haku.com.chatApplication.entities.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{

	@Query(value = "select new UserAccount(ua.accountId, ua.username, ua.email, ua.password, ua.avatarUrl, ua.role) from UserAccount ua where ua.username = :username")
	public UserAccount findByUsername(@Param("username") String username);
	
	@Query(value = "select new UserAccount(ua.accountId, ua.username, ua.email, ua.password, ua.avatarUrl, ua.role) from UserAccount ua where ua.email = :email")
	public UserAccount findByEmailAddress(@Param("email") String email);
	
	@Query(value = "select new UserAccount(ua.accountId, ua.username, ua.email, ua.password, ua.avatarUrl, ua.role) from UserAccount ua where ua.email = :email and ua.password = :password")
	public UserAccount login(@Param("email") String email, @Param("password") String password);
	
	
}
