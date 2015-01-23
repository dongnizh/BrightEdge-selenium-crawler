package WebCrawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 * fetch total nums of a searching item
 * @author zhaodongni
 *
 */
public class FetchTotalNum {
	/**
	 * get numbers of searching item
	 * @param url for searching
	 */
	public void fetchNum(String url)
	{
		Document doc;
		
		try {
	 
			// need http protocol
			doc = Jsoup.connect(url).get();
	 
	 
			// get result from the html page 
			Elements links = doc.select("#sortFiltersBox");
			
			//get num from innerHTML value
			String numValue = links.select("span.numTotalResults").html();
			int lastIndexOfNum = numValue.lastIndexOf(" ");
			String value = numValue.substring(lastIndexOfNum+1);
			
			System.out.println(value);
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
