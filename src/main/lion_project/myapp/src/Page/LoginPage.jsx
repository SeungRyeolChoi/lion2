import React, { useState,useEffect } from 'react';
import Modal from './ModalPage';
import { useNavigate } from 'react-router-dom';
function LoginPage() {

    const [Telephone, setTelephone] = useState("");
    const [isOpen, setIsOpen] = useState(false); 
    const navigate = useNavigate(); // navigate 함수를 초기화합니다
    const onTelephoneHandler = (event) => {
        setTelephone(event.currentTarget.value);
    }

    const handlelogin = async(event) => {
        event.preventDefault();
        console.log(localStorage.getItem('phone'));
        if(Telephone == localStorage.getItem('phone')) {alert("로그인 성공");navigate('/timeline');}
        else {alert("로그인 실패 ! 휴대폰 인증 해주세요")};
        const requestBody = {
            Telephone: Telephone,
          };
      
          fetch("http://localhost:3001/login", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(requestBody),
          })
            .then((res) => res.json())
            .then((data) => {
              console.log(data);
              // 여기에서 필요한 처리를 수행합니다.
            })
            .catch((error) => {
              console.error("Error:", error);
            });

        
    }
    const openModalHandler = (event) => {
        // isOpen의 상태를 변경하는 메소드를 구현
        // !false -> !true -> !false
        event.preventDefault();
        setIsOpen(!isOpen) 
    };
    
    
    return (
        <div className='div-outer'>
            <form className='div-inner'>
                <section className='sec-container'>
                    <h1 className='header-title'>인스타그랜마</h1>
                    <input className='input-tel' type='tel' value={Telephone} onChange={onTelephoneHandler} placeholder='전화번호'/>
                    <br/>
                    <button className='button-login' formAction='' onClick={handlelogin}>로그인</button>
                    
                </section>
            </form>
            <form className='div-inner2'>
                <section className='sec-container'>
                <button className='button-register' formAction='' onClick={openModalHandler}>휴대폰 인증</button>
                {isOpen ? <Modal openModalHandler={openModalHandler} /> : null}
                </section>
            </form>
        </div>
       
        
    )
 }
 
export default LoginPage;

