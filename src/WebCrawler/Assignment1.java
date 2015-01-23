package WebCrawler;

/**
 *given a key word,return number of available items
 * @author zhaodongni
 *
 */
public class Assignment1 {
	static final String domain = "http://www.shopping.com";
	
	public static void main(String[] args) {
		 
		//using REST method to get html page
		
		//check for available args
		if(args.length==0)
		{
			System.out.println("ATTENTION : please enter a keyword for searching!");
			return;
		}
		
		//load the html page from its url
		String url = GetURL.getURL(domain, args);
		FetchTotalNum fetchNum = new FetchTotalNum();
		fetchNum.fetchNum(url);
	 
	  }
}
