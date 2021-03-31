import React, { Component } from 'react'

 class Show extends Component {
    state={
        
        c:0
    };
updateEntry=()=>{
    this.setState({
        
        c:this.state.c+1
    });
 
}
 
updateExit=()=>{
    this.setState({
        
        c:this.state.c-1
    });
}
 welcome=()=>{
     window.alert("welcome");
 }
 clickOnMe=()=>{
     window.alert("I was clicked")
 }
 calculate=()=>{
     var ruppe=document.getElementById('rupees').value;
     if(document.getElementById('currency').value=='Euro'){
     var fin=ruppe * 85.67;
     window.alert('converted amount from euros to inr is'+ fin);
     }
     else
     {
         var fin=ruppe*0.012;
         window.alert('converted amount from inr to euoros is'+ fin);
     }
 }
    render() {
        return (
            <div className="people">
                <span id="entrycount"> {this.state.c} </span>
                <div>
                    <button onClick={this.updateEntry}>Increment</button>
                </div>
                <div>
                    <button onClick={this.updateExit}>Decrement</button>
                </div>
                <div>
                    <button onClick={this.welcome}>Say Welcome</button>
                </div>
                <div>
                    <button onClick={this.clickOnMe}>click on me</button>
                </div>
                <div>
                    <h1 id="converter">Currency Convertor</h1>
                </div>
                <div >
                    Rupees:<input type='number'id='rupees'/><br></br>
                    <br></br>
                    Currency:<input type='text' id='currency'/><br></br>
                    <button className='as1' onClick={this.calculate}>calculate</button>
                    
                </div>
            </div>
        )
    }
}
export default Show;