package Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.simplilearn.mavenproject.AppTest;

public class HTMLTables {
	
	private static final Logger logger = LogManager.getLogger(AppTest.class);

	public WebElement getTableElement(ChromeDriver driver)
	{
		return driver.findElement(By.id("customers"));
	}
      public String getTableCellText(WebElement table, int searchColumn,String searchText, int returnColumnText)
      {
    	  List<WebElement> tdInTable=table.findElements(By.tagName("td"));
    	  WebElement correctTr=null;
    	  for(int i=0;i<tdInTable.size();i++)
    	  {
    	  if(tdInTable.get(i).getText().equals(searchText))
    	  correctTr=table.findElement(By.xpath("//td[text()='"+searchText+"']/.."));
    	  }
    	  List<WebElement> tdInTr=correctTr.findElements(By.tagName("td"));
    	  return tdInTr.get(returnColumnText-1).getText();
      }
	public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) throws Exception
		{
		String value=getTableCellTextByXpath(table,searchColumn,searchText,returnColumnText);
		if(value.equals(expectedText))
			return true;
		return false;			
		}
	
	public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) 
			throws Exception
		{
		try
		{
		return table.findElement(By.xpath("//td["+searchColumn+"][text()='"+searchText+"']/../td["+returnColumnText+"]")).getText();	
		}
		catch (Exception e)
		{
			throw new Exception("Can't find value: "+e.getMessage());
		}
		}
	
}
