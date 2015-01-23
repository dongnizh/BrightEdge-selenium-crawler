package WebCrawler;

/**
 * set url from arguments and domain
 * @author zhaodongni
 *
 */
public class GetURL {
	
	/**
	 * make up a valid url by using REST
	 * @param domain
	 * @param args contains key word given from the command line, and page number given from the command line 
	 * @return url with protocol 
	 */
	public static String getURL(String domain, String[] args)
	{
		
		int pageNum =1;
		String url ="";
		//replace space to -
		String keyWord = args[0].toString().toLowerCase().replace(" ", "-");
				
		//escape url
		String keyWordTransform = args[0].toString();
		if(keyWordTransform.contains(" "))
		{
			//replace space
			keyWordTransform = keyWordTransform.toLowerCase().replace(" ","%20");
		}
		if(args.length>1)
		{
			pageNum =Integer.parseInt(args[1]);
			url = domain +"/"+ keyWord + "/products~PG-"+pageNum+"?CLT=SCH&KW=" + keyWordTransform;
		}
		else
			url = domain +"/"+ keyWord + "/products?CLT=SCH&KW=" + keyWordTransform;

		return url;
	}
}
