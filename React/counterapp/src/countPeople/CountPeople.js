import React,{Component} from 'react';
import './CountPeople.css';
class CountPeople extends Component{
    state={
        entrycount:0,
        exitcount:0
    };
    updateEntry=()=>{
        this.setState(
            {
                entrycount:this.state.entrycount+1
            }
        );
    }
    updateExit=()=>{
        this.setState(
            {
                exitcount:this.state.exitcount+1
            }
        );
    }
 
    render(){
        return(
             <div className='Count'>
                <div>
                    <button  className='button'onClick={this.updateEntry}>Login</button><span>{this.state.entrycount+' people entered!!!'}</span>
                    </div>
                    <div>
                    <button className='button' onClick={this.updateExit}>Exit</button><span>{this.state.exitcount+' people Left!!!'}</span>
                    </div>
            
                
             </div>



        );
    }
}
export default CountPeople;