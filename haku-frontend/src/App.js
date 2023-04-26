import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

//Components
import PageNavBar from './components/PageNavBar'
import Landing from './components/Landing'
import Chat from './components/Chat'
import ChatWithoutWS from './components/ChatWithoutWS'

// import components


const App = () => {

  return (
    <main className='site-wrapper'>
      <BrowserRouter>
        <PageNavBar />
        <Routes>

          <Route path="/" element={<Landing/>} />
          <Route path="/chat" element={<Chat/>} />
          <Route path="/chatnoWs" element={<ChatWithoutWS/>} />


        </Routes>
      </BrowserRouter>
    </main>
  )
}

export default App

