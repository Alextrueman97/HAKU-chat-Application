import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function Chat() {
  const [messages, setMessages] = useState([]);
  const [inputText, setInputText] = useState('');

  useEffect(() => {
    const socket = new WebSocket('ws://localhost:8080/chat');
    socket.onmessage = event => {
      const message = JSON.parse(event.data);
      setMessages(prevMessages => [...prevMessages, message]);
    };

    return () => {
      socket.close();
    };
  }, []);

  const handleInputTextChange = event => {
    setInputText(event.target.value);
  };

  const handleSendMessage = () => {
    axios.post('/chat', {
      from: 'user',
      text: inputText
    });
    setInputText('');
  };

  return (
    <div>
      <ul>
        {messages.map((message, index) => (
          <li key={index}>
            {message.from}: {message.text} ({message.time})
          </li>
        ))}
      </ul>
      <input type="text" value={inputText} onChange={handleInputTextChange} />
      <button onClick={handleSendMessage}>Send</button>
    </div>
  );
}