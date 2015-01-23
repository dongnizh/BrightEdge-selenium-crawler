package WebCrawler;

import java.util.ArrayList;

/**
 * gather items 
 * @author zhaodongni
 *
 */
public class ResultObject {
	
	ArrayList<Object> result = new ArrayList<Object>();
	
	
	/**
	 * print out all the items available from an ArrayList
	 */
	public void printItem()
	{
		
		for(int i = 0; i<result.size() ;i++)
		{
			System.out.println("No : "+ (i+1));
			System.out.println("Title/Product Name : "+ result.get(i).getTitle());
			System.out.println("Price of the product : "+ result.get(i).getPrice());
			printShipPrice(result.get(i).getShipPrice());
			printVendor(result.get(i).getVendor());
			System.out.println("\n");
		}
	}
	
	/**
	 * print out item shipping prices
	 * @param shipPrice 
	 */
	public void printShipPrice(ArrayList<String> shipPrice)
	{
		
		int shipPriceSize = shipPrice.size();
		int i=0;
		System.out.print("Shipping Price : ");
		for( ; i< shipPriceSize-1; i++)
		{
			System.out.print("\""+shipPrice.get(i)+"\", ");
		}
		System.out.print("\""+shipPrice.get(i)+"\"");
		System.out.print("\n");
	}
	
	/**
	 * print out item vendors
	 * @param vendor
	 */
	public void printVendor(ArrayList<String> vendor)
	{
		int vendorSize = vendor.size();
		int i=0;
		System.out.print("Vendor : ");
		for( ; i< vendorSize-1; i++)
		{
			System.out.print("\""+vendor.get(i)+"\", ");
		}
		System.out.print("\""+vendor.get(i)+"\"");
		System.out.print("\n");
		
	}
	
	/**
	 * add all available items
	 * @param item each item on the page 
	 */
	public void add(Object item)
	{
		result.add(item);
	}
}
