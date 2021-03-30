import React from 'react';
import LoginButton from './LoginButton'
import LogoutButton from './LogoutButton'
function Greeting(props){
    let isLoggedin=props.status
    if(isLoggedin){
    return(
        <div>

           
           <LoginButton onClick={props.onClick}/>

        </div>
    )
    }
    else{
        return(<div>
            
             <LogoutButton onClick={props.onClick}/>
             </div>)
    }
}
export default Greeting;