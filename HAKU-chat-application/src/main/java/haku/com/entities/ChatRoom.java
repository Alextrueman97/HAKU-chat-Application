package haku.com.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_rooms")
public class ChatRoom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatRoomId;
    
    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserAccount userAccount;
    
    @OneToMany(mappedBy = "chatRoom")
    private List<Messages> messages;
    
    private String chatRoomName;
    
    private String chatRoomPassword;

	public ChatRoom() {
		super();
	}

	public ChatRoom(int chatRoomId, UserAccount userAccount, List<Messages> messages, String chatRoomName,
			String chatRoomPassword) {
		super();
		this.chatRoomId = chatRoomId;
		this.userAccount = userAccount;
		this.messages = messages;
		this.chatRoomName = chatRoomName;
		this.chatRoomPassword = chatRoomPassword;
	}

	
	public int getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}

	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}

	public String getChatRoomPassword() {
		return chatRoomPassword;
	}

	public void setChatRoomPassword(String chatRoomPassword) {
		this.chatRoomPassword = chatRoomPassword;
	}

    
}
