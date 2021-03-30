import React from 'react';
const LogoutButton=(props)=>{
       return(
           <div>
           <h1>Welcome Back</h1>
           <button onClick={props.onClick}>
               Logout
           </button>
           </div>
       );
}
export default LogoutButton;