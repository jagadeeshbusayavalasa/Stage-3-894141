import logo from './logo.svg';
import './App.css';
import ListOfPlayers from './ListOfPlayers';
import Playerslessthan70 from './PlayerLess';
import OddPlayers from './OddPlayers';
function App() {
  let flag;
 if(flag===true){
  return (   
    <div>
      <ListOfPlayers />
      <hr/>
      <Playerslessthan70 />
    </div>
  );
    }
    else{
      return(
      <div>
      <OddPlayers />
      </div>
      );
    }
  
}

export default App;