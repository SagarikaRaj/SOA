package iit.edu.LeatherStore;

import java.util.Date;

public class Customers 
{
	int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getADDRESS_LINE1() {
		return ADDRESS_LINE1;
	}
	public void setADDRESS_LINE1(String aDDRESS_LINE1) {
		ADDRESS_LINE1 = aDDRESS_LINE1;
	}
	public String getADDRESS_LINE2() {
		return ADDRESS_LINE2;
	}
	public void setADDRESS_LINE2(String aDDRESS_LINE2) {
		ADDRESS_LINE2 = aDDRESS_LINE2;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public int getZIPCODE() {
		return ZIPCODE;
	}
	public void setZIPCODE(int zIPCODE) {
		ZIPCODE = zIPCODE;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPSSWORD() {
		return PSSWORD;
	}
	public void setPSSWORD(String pSSWORD) {
		PSSWORD = pSSWORD;
	}
	public Date getENROLL_DATE() {
		return ENROLL_DATE;
	}
	public void setENROLL_DATE(Date eNROLL_DATE) {
		ENROLL_DATE = eNROLL_DATE;
	}
	String name;
	String ADDRESS_LINE1;
	String ADDRESS_LINE2;
	String STATE;
	int ZIPCODE;
	String PHONE;
	String EMAIL;
	String PSSWORD;
	Date ENROLL_DATE;
	
}
