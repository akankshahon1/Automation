package testcases;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

//import io.appium.java_client.gecko.GeckoDriver;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
@RunWith(SerenityRunner.class)


public class LoginTest extends PageObject{
	
	@Managed(driver="chrome")
	WebDriver driver=new ChromeDriver();
	//WebDriver driver=new FirefoxDriver();
	
	@FindBy(name="q")
	
	WebElement googleSearch;
	@Title("Ëxecuting Login Test")
	
	@Test
	public void doLogin()
	{
		
		open();
		
		System.out.println(getTitle());
		
		
		//driver.get("http://google.com");
		//driver.findElement(By.name("q")).sendKeys("Hello serenity !!!");
		//getDriver().findElement(By.name("q")).sendKeys("Hello serenity !!!");
		//find(By.name("q")).sendKeys("Hello serenity !!!");
		//find(By.xpath("//*[@name='q']")).sendKeys("Hello serenity !!!");
		//$("//*[@name='q']").sendKeys("Hello serenity !!!");
		typeInto($("//*[@name='q']"),"Hello Serenity!!");
		
		WebElementFacade textbox=find(By.name("q"));
		
		textbox.shouldBePresent();
		
		//textbox.type("Hello selenium!!!");
		textbox.typeAndEnter("Hello selenium!!!");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

