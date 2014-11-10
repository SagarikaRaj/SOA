package iit.edu.LeatherStore.Services;

import iit.edu.LeatherStore.Customers;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

/**
 * Service to get all Customers enrolled after a particular date
 */

@WebService(serviceName="CustomerService")
public class CustomersService 
{
	DBProperties dbConnect = new DBProperties();
	 
	public List<Customers> getCustomers(String date) 
	{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String customerSQL = "select name"+
								",      NVL(state,'No State') as state"+
								",      NVL(zipcode,0) as zipcode"+
								",      NVL(phone,0) as phone"+
								",      NVL(enroll_date,'') as enroll_date"+
								" from   customers"+
								" where  enroll_date > to_date( '"+date+"')";
			
			System.out.println(customerSQL);
			String name ;
			String state ;
			int zipcode;
			String phone ;
			Date enroll_date;
			List<Customers> customers = new ArrayList<Customers>();
			
			try
			{
			     //STEP 2: Register JDBC driver
			     Class.forName("oracle.jdbc.driver.OracleDriver");
		
			     //STEP 3: Open a connection
			     System.out.println("Connecting to database...");
			     conn = DriverManager.getConnection(dbConnect.DB_URL,dbConnect.USER,dbConnect.PASS);
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(customerSQL);
			    		     
		         while(rs.next()) 
		         {
		        	 Customers customer = new Customers();
		        	
		        	 name = rs.getString("name");
		        	 customer.setName(name);
		             
		        	 state = rs.getString("state");
		        	 customer.setSTATE(state);
		        	 
		        	 zipcode = rs.getInt("zipcode");
		        	 customer.setZIPCODE(zipcode);
		             
		        	 phone = rs.getString("phone");
		        	 customer.setPHONE(phone);
		         

		        	enroll_date = rs.getDate("enroll_date");
		        	customer.setENROLL_DATE(enroll_date);
		 			 
		        	customers.add(customer);
		         }
		         System.out.println("Printing Products   *** " );
		         for(int j=0;j<customers.size();j++)
		         {
		        	 
		        	 System.out.println(customers.get(j).getName());
		        	 System.out.println(customers.get(j).getSTATE());
		        	 System.out.println(customers.get(j).getZIPCODE());
		        	 System.out.println(customers.get(j).getPHONE());
		        	 System.out.println(customers.get(j).getENROLL_DATE());
		         }
		         return customers;
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
	return customers;
}

}
