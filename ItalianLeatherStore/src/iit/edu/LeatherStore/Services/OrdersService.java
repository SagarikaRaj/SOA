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

/*
 * Service to retrieve all Orders giving a month/year (Service API  getOrders(int month, int year))
 * */

@WebService(serviceName="Orders")
public class OrdersService 
{
	DBProperties dbConnect = new DBProperties();
	 
	public List<Orders> getOrders(int year,int month) 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//String serviceCustomer = "SELECT id,name FROM customers WHERE enroll_date > to_char('"+customerName+"','DD-MON-YYYY')"; 
		String serviceCustomer = "SELECT id,order_date,total_price,status FROM orders WHERE to_char(order_date,'MM') = " +month+ "  and   extract(year from order_date) ="+ year;
		System.out.println(serviceCustomer);
		int result = 0;
		Date orderDate ;
		int totalPrice;
		String status ;
		List<Orders> orders = new ArrayList<Orders>();
		
		
		try
		{
		     //STEP 2: Register JDBC driver
		     Class.forName("oracle.jdbc.driver.OracleDriver");

		     //STEP 3: Open a connection
		     System.out.println("Connecting to database...");
		     conn = DriverManager.getConnection(dbConnect.DB_URL,dbConnect.USER,dbConnect.PASS);
		     stmt = conn.createStatement();
		     rs = stmt.executeQuery(serviceCustomer);
		    		     
	         while(rs.next()) 
	         {
	        	 Orders order = new Orders();
	        	 result = rs.getInt(1);
	        	 order.setID(result);
	             
	        	 orderDate = rs.getDate("order_date");
	        	 order.setORDER_DATE(orderDate);
	        	 
	        	 totalPrice = rs.getInt("total_price");
	             order.setTOTAL_PRICE(totalPrice);
	             
	             status = rs.getString("status");
	             order.setSTATUS(status);
	         
	             orders.add(order);
	         }
	         System.out.println("Printing Orders   *** " );
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
