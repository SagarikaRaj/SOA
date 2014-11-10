package iit.edu.LeatherStore.Services;

import iit.edu.LeatherStore.Orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

/*service for returning orders that are not shipped*/


@WebService(serviceName="OrdersNotShipped")
public class OrdersNotShippedService 
{
	DBProperties dbConnect = new DBProperties();
	 
	public List<Orders> getOrdersNotShipped() 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String ordersNotShipped = "select o.id as orderID"+
									",      o.order_date as OrderDate"+
									",      o.total_price as OrderPrice"+
									",      o.status as OrderStatus"+
									" from orders o"+    
									" where o.status != 'SHIPPED'";
		System.out.println(ordersNotShipped);
		int orderId = 0;
		Date orderDate ;
		int orderPrice;
		String orderStatus ;
		List<Orders> orders = new ArrayList<Orders>();
		
		
		try
		{
		     //STEP 2: Register JDBC driver
		     Class.forName("oracle.jdbc.driver.OracleDriver");

		     //STEP 3: Open a connection
		     System.out.println("Connecting to database...");
		     conn = DriverManager.getConnection(dbConnect.DB_URL,dbConnect.USER,dbConnect.PASS);
		     stmt = conn.createStatement();
		     rs = stmt.executeQuery(ordersNotShipped);
		    		     
	         while(rs.next()) 
	         {
	        	 Orders order = new Orders();
	        	 orderId = rs.getInt("orderID");
	        	 order.setID(orderId);
	             
	        	 orderDate = rs.getDate("OrderDate");
	        	 order.setORDER_DATE(orderDate);
	        	 
	        	 orderPrice = rs.getInt("OrderPrice");
	             order.setTOTAL_PRICE(orderPrice);
	             
	             orderStatus = rs.getString("OrderStatus");
	             order.setSTATUS(orderStatus);
	         
	             orders.add(order);
	         }
	         System.out.println("Printing Orders Not Shipped   *** " );
	         for(int j=0;j<orders.size();j++)
	         {
	        	 System.out.println(orders.get(j).getID());
	        	 System.out.println(orders.get(j).getORDER_DATE());
	        	 System.out.println(orders.get(j).getTOTAL_PRICE());
	        	 System.out.println(orders.get(j).getSTATUS());
	         }
	         return orders;
		}
		catch (SQLException e) 
		{
		   	 System.out.println(e);
		}
		catch (ClassNotFoundException e1)
		{
			  System.out.println(e1);
		}
		
		finally 
		{
            try 
            {
                rs.close();
                stmt.close();
                conn.close();
            }
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
            
		
		}
		return orders;
	}
}
