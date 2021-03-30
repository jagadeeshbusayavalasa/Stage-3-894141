import logo from './logo.svg';
import './App.css';
import React,{Component} from 'react'
import Greeting from './greeting/Greeting'
class App extends Component {

   state={isLoggedin:true
   };
   loginhandler=()=>
{
   this.setState(
     {
        isLoggedin:!this.state.isLoggedin
     }
   );
};
   render(){
  return (
    <div className="App">
         <Greeting onClick={this.loginhandler}status={this.state.isLoggedin}/>
         </div>
  );
   }
}

export default App;
