import React from 'react';
const LoginButton=(props)=>{
       return(
           <div>
           <h1>Please Sign Up</h1>
           <button onClick={props.onClick}>
               Login
           </button>
           </div>
       );
}
export default LoginButton;