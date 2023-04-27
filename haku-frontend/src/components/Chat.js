import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function Chat() {
  const [messages, setMessages] = useState([]);
  const [inputText, setInputText] = useState('');
  const [socket, setSocket] = useState(null);

  useEffect(() => {
    const socket = new WebSocket('ws://localhost:8080/chatApp/chat');
    socket.onmessage = event => {
      const message = JSON.parse(event.data);
      setMessages(prevMessages => [...prevMessages, message]);
    };
    socket.onopen = () => {
      socket.send(JSON.stringify({ type: 'SUBSCRIBE', destination: '/topic/messages'}));
    }
    setSocket(socket);


    return () => {
      socket.close();
    };
  }, []);

  const handleInputTextChange = event => {
    setInputText(event.target.value);
  };

 /* const handleSendMessage = () => {
    axios.post('/chat', {
      from: 'user',
      text: inputText
    });
    setInputText('');
  };*/

  const handleSendMessage = () => {
    const message = {
      from: 'user',
      text: inputText,
      time: new Date().toLocaleTimeString()
    };
    socket.send(JSON.stringify({ type: 'SEND', destination: '/app/chat', body: JSON.stringify(message) }));
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