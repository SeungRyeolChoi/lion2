import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // useNavigate를 가져옵니다
import LoginPage from './LoginPage';

function RegisterPage(props) {
    const navigate = useNavigate(); // navigate 함수를 초기화합니다

    const [Email, setEmail] = useState("");

    const onPhonenumHandler = (event) => {
        setEmail(event.currentTarget.value);
    }
   
    const onSubmitHandler = (event) => {
        event.preventDefault();

        localStorage.setItem('phone', Email);
        console.log(localStorage.getItem('phone'));

        // navigate 함수를 사용하여 LoginPage로 이동합니다
        navigate('/');
    }

    return (
            <div className='div-outer'>
                <form className='div-inner' onSubmit={onSubmitHandler}>
                    <h1 className='header-title'>인스타그랜마</h1>
                    <input type='tel' className='input-tel' value={Email} onChange={onPhonenumHandler} placeholder='전화번호'/>
                    <br />
                    <button className='button-register' type="submit">가입하기</button> {/* type을 "submit"으로 변경합니다 */}
                </form>
                </div>

    )
}

export default RegisterPage;