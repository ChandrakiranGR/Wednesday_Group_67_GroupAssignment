
package model.OrderManagement;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderReport {
    ArrayList<OrderSummary> ordersummarylist;
    
    public MasterOrderReport(){
        
        ordersummarylist = new ArrayList();
        
    }
    public void generateOrderReport(ArrayList<CurrentOrder> orders){
        ArrayList<CurrentOrder> orderlist = orders;
        OrderSummary ordersummary ;
        for(CurrentOrder order: orderlist){
            ordersummary = new OrderSummary(order);
            ordersummarylist.add(ordersummary);
        }         
    }
    
    public OrderSummary getTopProfitableOrder(){ 
        OrderSummary currenttoporder = null;
        
        for (OrderSummary os: ordersummarylist){
            if(currenttoporder == null)currenttoporder= os;  
            else 
                if(os.getOrderProfit()> currenttoporder.getOrderProfit()){
                currenttoporder = os;
            }
                }
        return currenttoporder;
    }
}

