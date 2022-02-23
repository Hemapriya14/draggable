package week3.day3webtable;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("http://www.leafground.com/pages/table.html");
driver.manage().window().maximize();


//get column count
List<WebElement> columnCount=driver.findElements(By.tagName("th"));
int size=columnCount.size();
System.out.println("columnCount: "+size);


//get rowcount

List<WebElement> rowCount=driver.findElements(By.tagName("tr"));
int siz=rowCount.size();
System.out.println("rowCount: "+siz);

//get progressvalue
String progressivevalue=driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td[1]")).getText();
		
	
System.out.println("progressivevalue: +progressivevalue");

List<Integer>minValue=new ArrayList<Integer>();
for(int i=2;i<=siz;i++) {
	String text=driver.findElement(By.xpath("//table[@id='table_id']//tr[\"+i+\"]//td[2]")).getText();
	
	
	//System.out.println(text);
	
			String replaceAll = text.replaceAll("%", "");
			//System.out.println(replaceAll);
			int parseInt = Integer.parseInt(replaceAll);
			System.out.println(parseInt);
			
			
			minValue.add(parseInt);
			}
				
			System.out.println(minValue);
			Integer min = Collections.min(minValue);
			
			System.out.println("minimumValue: "+min);
			
			driver.findElement(By.xpath("//td[contains(text(),'"+min+"')]/following-sibling::td[1]/input")).click();
							                          
							                             //////td[contains(text(),'30')]/following-sibling::td/input
}
	}


