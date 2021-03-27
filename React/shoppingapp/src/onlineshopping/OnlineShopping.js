import reactDom from "react-dom";
import React,{Component} from 'react';
import Cart from '../Cart/cart';
import './OnlineShopping.css';
class OnlineShopping extends Component{
    render(){
             const CartInfo=[
                 {itemName:'Laptop',price:80000},
                 {itemName:'TV',price:120000},
                 {itemName:'Washing Machine',price:50000},
                 {itemName:'Mobile',price:30000},
                 {itemName:'Fridge',price:70000}];

         return(
             <div >
             <h1 className='OnlineShopping'>Items Ordered:</h1>
              <Cart item={CartInfo}/>
              </div>

         );


    }




}
export default OnlineShopping;