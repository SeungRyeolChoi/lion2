import React, { useState } from 'react'
import Post from './posts/Post'

import "./Timeline.css"
import '../App.css';
import EmailOutlinedIcon from '@mui/icons-material/EmailOutlined';
import LightbulbOutlinedIcon from '@mui/icons-material/LightbulbOutlined';
import AddPhotoAlternateOutlinedIcon from '@mui/icons-material/AddPhotoAlternateOutlined';
import { useNavigate } from "react-router-dom";
//우리가 만든 고유한 포스트
function Timeline()  {
  const navigate = useNavigate();
  fetch("http://localhost:3001/timeline", {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
            },
          })
            .then((res) => res.json())
            .then((data) => {
              console.log(data);
              // 여기에서 필요한 처리를 수행합니다.
            })
            .catch((error) => {
              console.error("Error:", error);
            });

  
  const [posts,setPosts] = useState([
      {
        post_id:1,
        user:"이영필",
        postImage: "https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F469%2F2014%2F06%2F27%2F1ea2778d6dc84a3fb799e993fd7e3289_99_20140627204503.jpg&type=sc960_832",
        likes:"12%",
        timestamp:"2시간 전",
      },
      {
        post_id:2,
        user:"김철수",
        postImage: "https://cdn.pixabay.com/photo/2015/02/27/03/20/warm-feeling-651473_1280.jpg",
        likes:"20%",
        timestamp:"12시간 전",
      },
      { post_id:3,
        user:"최영희",
        postImage: "https://cdn.pixabay.com/photo/2018/08/12/19/51/senior-3601588_1280.jpg",
        likes:"35%",
        timestamp:"하루 전",
      },
  ]);
  const hadlePostbutton =()=> {
    navigate('/post')
  }

    // 백엔드로부터 받은 새로운 포스트 정보를 추가하는 함수
    //const addNewPost = (newPost) => {
    //setPosts((prevPosts) => [...prevPosts, newPost]);
    //};

  return (
    <div className="app">
    <div className='app-header'>
        <h1>손주자랑</h1>
        <div className='header-icons'>
        <button className='header-button' onClick={hadlePostbutton}><AddPhotoAlternateOutlinedIcon fontSize='large' /></button>
        <LightbulbOutlinedIcon fontSize="large"/>
        <EmailOutlinedIcon fontSize="large"/> 
        </div>
    </div>
    <div className="timeline">
      <div className="timeline_left">
        <div className="timeline_post">
          {posts.map(post =>(
            <Post
            key={post.post_id} // 프론트엔드와 백엔드 간의 고유한 식별자(ID)
            user={post.user} 
            postImage={post.postImage} 
            likes={post.likes}
            timestamp={post.timestamp}
            post_id={post.post_id}  //post id 추가전달
            posts={posts} /> 
           
          ))}
        </div>
      </div>
      <div className='timeline_right'>
        
      </div>
    </div>
    </div>
  )
}

export default Timeline
