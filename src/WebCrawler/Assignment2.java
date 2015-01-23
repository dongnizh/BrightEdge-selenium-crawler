package WebCrawler;

/**
 * given a key word and page number you want, return item details(title, price, shipping price and vendors) on that page
 * @author zhaodongni
 *
 */
public class Assignment2 {
	
	static final String domain = "http://www.shopping.com" ;

	public static void main(String[] args) {
		 
		if(args.length<1)
		{
			System.out.println("ATTENTION : Please input the key word and page number you want ot search for!");
			return;
		}
		
		
		//using REST method to get html page
		String url = GetURL.getURL(domain, args);
		FetchResult result= new FetchResult(url);
		result.fetch();
	  }
	
	
}
