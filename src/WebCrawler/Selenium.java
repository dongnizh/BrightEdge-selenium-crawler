package WebCrawler;
import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {

	public WebDriver driver = new FirefoxDriver();

	/**
	 * Open the test website.
	 */
	public void openTestSite() {
		driver.navigate().to("http://www.allspicerestaurant.com/menu.html");
	}

	public void login()
	{
		WebElement submit_button = driver.findElement(By.xpath("//div[@id='nav']//li[2]"));
		submit_button.click();
	}
	/**
	 * grabs the status text and saves that into status.txt file
	 * 
	 * @throws IOException
	 */
	public void getText() throws IOException {
		String text = driver.findElement(By.xpath("//ul[@class='locu-nav']/li[1]")).getText();
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
		writer.write(text);
		writer.close();

	}

	/**
	 * Saves the screenshot
	 * 
	 * @throws IOException
	 */
	public void saveScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot.png"));
	}

	public void closeBrowser() {
		driver.close();
	}

//	public static void main(String[] args) throws IOException {
//		Selenium webSrcapper = new Selenium();
//		webSrcapper.openTestSite();
//		webSrcapper.login();
//		webSrcapper.getText();
//		webSrcapper.saveScreenshot();
//		webSrcapper.closeBrowser();
//	}
}