/**
 * Service to get all product details - getInventory()
 */
package iit.edu.LeatherStore.Services;
import iit.edu.LeatherStore.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

/**
 * @author Sagarika
 *
 */

@WebService(serviceName="Inventory")
public class InventoryService 
{
	DBProperties dbConnect = new DBProperties();
	 
	public List<Products> getInventory() 
	{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String inventorySQL = "select p.name as product"+
									",      p.description as prodDesc"+
									",      p.price as price"+
									",      p.model as productModel"+
									",      p.title as title"+
									",      p.weight as weight"+
									",      p.status as status"+
									",      p.color as color "+
/*									",      ca.category_name as category"+
									",      m.MANUFACTURER_NAME as manufacturer"+*/
									"from products p"/*+
									",    categories ca"+
									",    maufacturers m"+
									"where p.category_id = ca.id"+
									"and   p.manufacturer_id = m.id;"*/;
			
			System.out.println(inventorySQL);
			String productName ;
			String productDesc ;
			int productprice;
			String productModel ;
			String productTitle;
			float productWeight;
			String productStatus;
			String productColor;
			List<Products> products = new ArrayList<Products>();
			
			try
			{
			     //STEP 2: Register JDBC driver
			     Class.forName("oracle.jdbc.driver.OracleDriver");
		
			     //STEP 3: Open a connection
			     System.out.println("Connecting to database...");
			     conn = DriverManager.getConnection(dbConnect.DB_URL,dbConnect.USER,dbConnect.PASS);
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(inventorySQL);
			    		     
		         while(rs.next()) 
		         {
		        	Products product = new Products();
		        	
		 			productName = rs.getString("product");
		        	product.setNAME(productName);
		             
		        	productDesc = rs.getString("prodDesc");
		        	product.setDESCRIPTION(productDesc);
		        	 
		        	productprice = rs.getInt("price");
		        	product.setPRICE(productprice);
		             
		        	productModel = rs.getString("productModel");
		        	product.setMODEL(productModel);
		         

		 			 productTitle = rs.getString("title");
		 			 product.setTITLE(productTitle);
		 			 
		 			 productWeight = rs.getFloat("weight");
		 			 product.setWEIGHT(productWeight);
		 			 
		 			 productStatus = rs.getString("status");
		 			 product.setSTATUS(productStatus);
		 			 
		 			 productColor = rs.getString("color");
		 			 product.setCOLOR(productColor);
		        	
		            products.add(product);
		         }
		         System.out.println("Printing Products   *** " );
		         for(int j=0;j<products.size();j++)
		         {
		        	 System.out.println(products.get(j).getID());
		        	 System.out.println(products.get(j).getNAME());
		        	 System.out.println(products.get(j).getDESCRIPTION());
		        	 System.out.println(products.get(j).getSTATUS());
		         }
		         return products;
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
	return products;
}

}
