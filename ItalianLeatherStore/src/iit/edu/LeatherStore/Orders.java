package iit.edu.LeatherStore;

import java.util.Date;

public class Orders
{
	int ID;
	int CUSTOMER_ID;
	Date ORDER_DATE;
	int TOTAL_PRICE;
	String STATUS;
	String SHIPPING_ADDRESS;
	String BILLING_ADDRESS;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(int cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public Date getORDER_DATE() {
		return ORDER_DATE;
	}
	public void setORDER_DATE(Date oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}
	public int getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}
	public void setTOTAL_PRICE(int tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getSHIPPING_ADDRESS() {
		return SHIPPING_ADDRESS;
	}
	public void setSHIPPING_ADDRESS(String sHIPPING_ADDRESS) {
		SHIPPING_ADDRESS = sHIPPING_ADDRESS;
	}
	public String getBILLING_ADDRESS() {
		return BILLING_ADDRESS;
	}
	public void setBILLING_ADDRESS(String bILLING_ADDRESS) {
		BILLING_ADDRESS = bILLING_ADDRESS;
	}
	
}
