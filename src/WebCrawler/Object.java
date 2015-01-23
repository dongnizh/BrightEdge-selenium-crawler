package WebCrawler;

import java.util.ArrayList;

/**
 * to store each item on the page 
 * @author zhaodongni
 *
 */
public class Object {
	String title = "";
	String price = "";
	ArrayList<String> shipPrice = new ArrayList<String>();
	ArrayList<String> vendor = new ArrayList<String>();
	
	/**
	 * initialize an empty object
	 */
	public Object()
	{
		//
	}
	
	/**
	 * initialize item with value
	 * @param title
	 * @param price
	 * @param shipPrice
	 * @param vendor
	 */
	public Object(String title, String price, String shipPrice, String vendor)
	{
		this.title = title;
		this.price = price;
		this.shipPrice.add(shipPrice);
		this.vendor.add(vendor);
	}
	
	/**
	 * get item title
	 * @return item title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * get item price
	 * @return item price
	 */
	public String getPrice()
	{
		return price;
	}
	
	/**
	 * get item shipping price
	 * @return shipping price
	 */
	public ArrayList<String> getShipPrice()
	{
		
		return shipPrice;
	}
	
	/**
	 * get item vendors
	 * @return item vendors
	 */
	public ArrayList<String> getVendor()
	{
		return vendor;
	}
	
	
	/**
	 * set item title
	 * @param title set title value
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	/**
	 * set item price
	 * @param price set price value
	 */
	public void setPrice(String price)
	{
		this.price = price;
	}
	
	/**
	 * set item shipping price
	 * @param shipPrice set shipping prices
	 */
	@SuppressWarnings("unchecked")
	public void setShipPrice(ArrayList<String> shipPrice)
	{
		this.shipPrice = (ArrayList<String>)shipPrice.clone();
	}
	
	/**
	 * set item vendors
	 * @param vendor set available vendor list
	 */
	@SuppressWarnings("unchecked")
	public void setVendor(ArrayList<String> vendor)
	{
		this.vendor =  (ArrayList<String>)vendor.clone();
	}
	
	
		
}
