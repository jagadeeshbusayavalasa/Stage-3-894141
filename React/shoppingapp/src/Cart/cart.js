import React,{Component} from'react';
import './cart.css';
class Cart extends Component{

    render(){

         let items=this.props.item.map(item=>{
             return(
                  <tr>
                      <td>{item.itemName}</td>
                      <td>{item.price}</td>
                  </tr>


             )
         });
         return(
             <table className='Cart' border='1' align='center'>
                 <tr >
                     <th>Item</th>
                     <th>Price</th>
                 </tr>
                    {items}
             </table>
         )


    }
}
export default Cart;