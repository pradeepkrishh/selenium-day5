package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task4 {
	public static void main(String args[])
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver;
	ChromeOptions co=new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(co);
	driver.get("https://www.abhibus.com/bus-ticket-booking");
	WebElement board=driver.findElement(By.id("source"));
	board.sendKeys("coimbatore",Keys.ENTER);
	WebElement drop=driver.findElement(By.id("destination"));
	drop.sendKeys("Gobi",Keys.ENTER);
	WebElement date=driver.findElement(By.id("datepicker1"));
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('value','13/04/2023' )",date);
	
			
	
	}
}