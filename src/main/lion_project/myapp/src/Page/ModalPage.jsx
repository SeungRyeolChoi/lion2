import React, { useState,useEffect } from "react";
import Timer from "./TimerPage";
import { useNavigate } from 'react-router-dom';

function Modal(props) {
    const [Telephone, setTelephone] = useState("");
    const [Certnum, setCertnum] = useState("");
    const [Counter,setCounter] = useState(false);
    const navigate = useNavigate(); // navigate 함수를 초기화합니다
    const onTelephoneHandler = (event) => {
        setTelephone(event.currentTarget.value);
    }

    const onCertnumHandler = (event) => {
        setCertnum(event.currentTarget.value);
        setCounter(false);
    }

    const handleAuthlogin = async(event) => {
        event.preventDefault();
        localStorage.setItem('phone', Telephone);
        console.log(localStorage.getItem('phone'));
        if(Telephone == localStorage.getItem('phone')) {alert("로그인 성공");navigate('/timeline');}

}




    return (
        <div className="div-modal-container" onClick={props.openModalHandler}>
                    <div className="div-modal-inner-container" onClick={(e) => e.stopPropagation()}>
                        <button className="button-modal" onClick={props.openModalHandler}>x</button>
                        <br/>
                        <p className="p-content">1)문자를 못 받으셨을 경우는 아래에 재전송 눌러주세요</p>
                        <br/>
                        <div className="div-modal-tel">
                            <input className='input-tel input-modal-tel' type='tel' value={Telephone} onChange={onTelephoneHandler} placeholder='전화번호'/>
                            <button className="button-modal-tel">재전송</button>
                        </div>
                        <button className="button-input-modal-tel" onClick={(e) => {e.preventDefault();setCounter(!Counter);}}>입력</button>{Counter ? <Timer /> : null}
                        <p className="p-sec-content">2)휴대폰으로 전송된 4자리 인증번호를 입력하세요</p>
                        <div className="div-modal-certification">
                            <input className='input-tel input-modal-certification' type='tel' value={Certnum} onChange={onCertnumHandler} placeholder='인증번호'/>
                            <button className="button-modal-tel" onClick={handleAuthlogin}>입력</button>
                        </div>
                    </div>
        </div>
    )
    }
export default Modal;