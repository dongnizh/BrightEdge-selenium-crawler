package WebCrawler;

import java.util.ArrayList;

import org.jsoup.nodes.Element;

/**
 * fetch title, price, vendor and shipping price
 * @author zhaodongni
 *
 */
public class FetchElement {

	/**
	 * fetching item title
	 * @param element one element for one item
	 * @return String you fetched title
	 */
	public String fetchTitle(Element element)
	{
		Element itemTitle = element.select("a.productName").first();
		if(itemTitle.hasAttr("title"))
		{
			return itemTitle.attr("title");
		}
					
		//it will in the span tag
		else
		{
			return itemTitle.select("span").attr("title");
		}
	}
			
	/**
	 * fetching item price
	 * @param element one element for one item
	 * @return String you fetched price
	 */
	public String fetchPrice(Element element)
	{
		Element itemPrice = element.select("span.productPrice").first();
		String price = itemPrice.html();
				
		//some price inside has anchor inside
		if(price.contains("<"))
		{
			int start = price.indexOf("$");
			int end = price.indexOf("</");
			return price.substring(start,end);
		}
		else
		{
			return price;
		}
	}
			
			
	/**
	 * fetching item vendors
	 * @param element one element for one item 
	 * @return list of vendors 
	 */
	public  ArrayList<String> fetchVendor(Element element)
	{
		Element itemVendor = element.select(".newMerchantName").first();
		ArrayList<String> vendor = new ArrayList<String>();
		vendor.add(itemVendor.html());
		//get other available stores
		if(element.select(".gridItemBtm a.buyAtTxt").first()!=null)
		{
			vendor.add( element.select("a.buyAtTxt span").html());
		}
		return vendor;
	}
	
	/**
	 * fetching item shipping prices
	 * @param element one element for one item
	 * @return list of shipping prices 
	 */
	public ArrayList<String> fetchShipPrice(Element element)
	{
		Element itemShipPrice = element.select(".gridItemBtm").first();
				
		ArrayList<String> shipPrice = new ArrayList<String>();
		//fetch ship price on the page	
		if(itemShipPrice != null)
		{
			//free shipping
			if(itemShipPrice.select(".freeShip").first()!=null)
				shipPrice.add(itemShipPrice.select(".freeShip").html());
			
			//item has a shipping fee	
			else if(itemShipPrice.select(".calc").first()!=null)
				shipPrice.add(itemShipPrice.select(".calc").html().replace("+ ", ""));
			
			//item has no valid ship info	
			else if(itemShipPrice.select(".missCalc").first()!=null)	
				shipPrice.add(itemShipPrice.select(".missCalc").html());
			//shipping fee not mention 
			else
				shipPrice.add(new String(""));
		}
		return shipPrice;
	}
}
