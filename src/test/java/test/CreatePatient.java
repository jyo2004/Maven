package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreatePatient {
	
@Test
public void Createpatient() throws InterruptedException{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://demo.openemr.io/a/openemr");
	driver.findElement(By.id("authUser")).clear();
	driver.findElement(By.id("authUser")).sendKeys("admin");
	driver.findElement(By.id("clearPass")).clear();
	driver.findElement(By.id("clearPass")).sendKeys("pass");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Actions act =new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div/div[5]/div/div"))).perform();
	driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div/div[5]/div/ul/li[2]/div")).click();
	Thread.sleep(3000);
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
	Select title = new Select(driver.findElement(By.id("form_title")));
	title.selectByValue("Mrs.");
	driver.findElement(By.id("form_fname")).sendKeys("Jyo");
	driver.findElement(By.id("form_lname")).sendKeys("AA");
	driver.findElement(By.xpath("//input[@id='form_DOB']")).sendKeys("26/02/2021");
	driver.findElement(By.xpath("//input[@id='form_DOB']")).click();
	
	Select gender = new Select(driver.findElement(By.id("form_sex")));
	gender.selectByValue("Female");
	
	driver.findElement(By.id("create")).click();
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame(driver.findElement(By.id("modalframe")));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(3000);
	
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	
	//driver.findElement(By.className("closeDlgIframe")).click();
	
	driver.findElement(By.id("username")).click();
	driver.findElement(By.xpath("//li[@data-bind='click: logout']")).click();
	
	driver.quit();
	
}
}