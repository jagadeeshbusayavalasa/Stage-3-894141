import React, { Component } from 'react';
import players from './PlayersInfo/Players';
class  Player extends Component{
    render(){
        const{name,score}=this.props.player;
    return(
        <span>
            <li>{name} {score}</li>
        </span>
    )
    }
    
}
class PlayerLess extends Component{
    render(){
        return(
            <div>
                  <h2>Players List</h2>
                    <div>{
                       players.map(PLAYER =>{
                           if(PLAYER.score<=70){
                    return(
                        <Player key={PLAYER.id} player={PLAYER} />
                    );
                           }
                       }
                       )
                    }
                    </div>

                
            
            </div>
        );
    }
}
export default PlayerLess;