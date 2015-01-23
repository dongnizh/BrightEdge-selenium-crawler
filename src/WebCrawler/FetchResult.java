package WebCrawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * set fetching results into Object
 * @author zhaodongni
 *
 */
public class FetchResult {

	String url = "";
	
	/**
	 * pass url for searching
	 * @param url for searching
	 */
	public FetchResult(String url)
	{
		this.url = url;	
	}
	
	/**
	 * set result(item title, item price, item shipping price and item vendors) 
	 * into object(from the start to end)
	 */
	public void fetch()
	{
		
		FetchElement fetchTool = new FetchElement();
		ResultObject items = new ResultObject();
		//load the html page from its url
		Document doc;
		try 
		{
 
			// need http protocol
			doc = Jsoup.connect(url).get();
		
			// get result from the html page 
			Elements elements = doc.select("div.gridBox");
			for(Element element : elements)
			{
				Object item = new Object();

				
				//set value into object
				item.setTitle(fetchTool.fetchTitle(element));
				item.setPrice(fetchTool.fetchPrice(element));
				item.setVendor(fetchTool.fetchVendor(element));
				item.setShipPrice(fetchTool.fetchShipPrice(element));
				
			
			
				items.add(item);
			
			}
			//print out all the results
			items.printItem();
		
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
