package haku.com.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Messages {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
    
    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserAccount userAccount;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

	public Messages() {
		super();
	}

	public Messages(int messageId, UserAccount userAccount, String content, LocalDateTime timestamp,
			ChatRoom chatRoom) {
		super();
		this.messageId = messageId;
		this.userAccount = userAccount;
		this.content = content;
		this.timestamp = timestamp;
		this.chatRoom = chatRoom;
	}

	
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

    
}
