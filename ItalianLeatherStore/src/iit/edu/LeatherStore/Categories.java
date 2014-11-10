/**
 * 
 */
package iit.edu.LeatherStore;

/**
 * @author Sagarika
 *
 */
public class Categories
{
	int ID;
    String CATEGORY_NAME;
    String IMAGE_LOCATION;
	int PARENT_ID;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}
	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
	}
	public String getIMAGE_LOCATION() {
		return IMAGE_LOCATION;
	}
	public void setIMAGE_LOCATION(String iMAGE_LOCATION) {
		IMAGE_LOCATION = iMAGE_LOCATION;
	}
	public int getPARENT_ID() {
		return PARENT_ID;
	}
	public void setPARENT_ID(int pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}

}
