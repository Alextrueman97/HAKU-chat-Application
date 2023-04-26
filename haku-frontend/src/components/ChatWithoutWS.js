import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function ChatWithoutWS() {
  const [chat, setChat] = useState([]);
  const [text, setText] = useState('');

  useEffect(() => {
      fetchChat();
  }, []);

  const fetchChat = async () => {
      const response = await axios.get('/chat');
      setChat(response.data);
  };

  const sendMessage = async (event) => {
      event.preventDefault();
      const newChat = { text };
      await axios.post('/chat', newChat);
      setText('');
  };

  const handleTextChange = (event) => {
      setText(event.target.value);
  };

  return (
      <div>
          <h1>Chat</h1>
          <div>
              {chat.map((message, index) => (
                  <div key={index}>
                      <span>{message.from}: </span>
                      <span>{message.text}</span>
                  </div>
              ))}
          </div>
          <form onSubmit={sendMessage}>
              <input type="text" value={text} onChange={handleTextChange} placeholder="Message" />
              <button type="submit">Send</button>
          </form>
      </div>
  );
}
