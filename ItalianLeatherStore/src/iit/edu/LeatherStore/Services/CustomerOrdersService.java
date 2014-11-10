package iit.edu.LeatherStore.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

/*Service to retrieve all customers and their orders for a given year*/

@WebService(serviceName="CustomerOrders")
public class CustomerOrdersService 
{
	DBProperties dbConnect = new DBProperties();
	 
	public List<CustomerOrders> getCustomerOrders(int year) 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String customerOrderSQL = "select c.name as customer"+
									",      o.order_date as OrderDate"+
									",      o.total_price as OrderPrice"+
									",      o.status as OrderStatus "+
									"from customers c"+
									",    orders o "+
									"where o.customer_id = c.id "+ 
									"and   extract(year from order_date) = "+year;
		System.out.println(customerOrderSQL);
		String customerName;
		Date orderDate ;
		int orderPrice;
		String orderstatus ;
		List<CustomerOrders> customerOrders = new ArrayList<CustomerOrders>();
		
		
		try
		{
		     //STEP 2: Register JDBC driver
		     Class.forName("oracle.jdbc.driver.OracleDriver");

		     //STEP 3: Open a connection
		     System.out.println("Connecting to database...");
		     conn = DriverManager.getConnection(dbConnect.DB_URL,dbConnect.USER,dbConnect.PASS);
		     stmt = conn.createStatement();
		     rs = stmt.executeQuery(customerOrderSQL);
		    		     
	         while(rs.next()) 
	         {
	        	 CustomerOrders customerOrder = new CustomerOrders();
	        	 customerName = rs.getString("customer");
	        	 customerOrder.setCustomerName(customerName);
	             
	        	 orderDate = rs.getDate("OrderDate");
	        	 customerOrder.setOrderDate(orderDate);
	        	 
	        	 orderPrice = rs.getInt("OrderPrice");
	             customerOrder.setOrderPrice(orderPrice);
	             
	             orderstatus = rs.getString("OrderStatus");
	             customerOrder.setOrderStatus(orderstatus);
	         
	             customerOrders.add(customerOrder);
	         }
	         System.out.println("Printing Customers and their Orders   *** " );
	         for(int j=0;j<customerOrders.size();j++)
	         {
	        	 System.out.println(customerOrders.get(j).getCustomerName());
	        	 System.out.println(customerOrders.get(j).getOrderDate());
	        	 System.out.println(customerOrders.get(j).getOrderPrice());
	        	 System.out.println(customerOrders.get(j).getOrderPrice());
	         }
	         return customerOrders;
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
		return customerOrders;
	}
	
}
