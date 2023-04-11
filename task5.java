package day5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task5 {
	public static void main(String[] args)
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver;
	ChromeOptions co=new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(co);
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("Apple");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	String parent=driver.getWindowHandle();
	System.out.println(parent);
	System.out.println(driver.getTitle());
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("Selenium");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("Cucumber");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	Set<String>s=driver.getWindowHandles();
	System.out.println("Number of windows opened "+s.size());
	Iterator<String>ll=s.iterator();
	while(ll.hasNext())
	{
		String child=ll.next();
		if(parent.equals(child))
		{
			continue;
		}
		else
		{
			driver.switchTo().window(child);
			System.out.println(driver.switchTo().window(child).getWindowHandle());
			System.out.println(driver.switchTo().window(child).getTitle());
		}
	}
	
	
	}
}