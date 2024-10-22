package testcases;

import org.junit.Test;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.time.Duration;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(SerenityRunner.class)
public class SerenityGmailTest extends PageObject {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Title("Executing Login Test")
    @Test
    public void doLogin() {

        // Open the Gmail login page
        getDriver().get("http://gmail.com");

        // Explicit wait for the identifier input field
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
        emailField.sendKeys("trainer@way2automation.com");

        // Click on the Next button using JavaScript to avoid any state issues
//        WebElement nextButton = find(By.xpath("//*[@id='identifierNext']/span/span"));
        WebElement nextButton = find(By.xpath("//div[@id='identifierNext']"));
        
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", nextButton);

        // Wait for the password field to be visible and interactable
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]")));
        passwordField.sendKeys("trainer@way2automation");

        // Optionally add a sleep to observe the test (not recommended for production tests)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
 * package testcases; import org.openqa.selenium.chrome.ChromeDriver; import
 * org.junit.Test; import static java.time.temporal.ChronoUnit.SECONDS; import
 * java.time.Duration; import org.openqa.selenium.WebDriver; import
 * org.junit.runner.RunWith; import org.openqa.selenium.By; import
 * net.serenitybdd.annotations.Managed; import
 * net.serenitybdd.annotations.Title; import
 * net.serenitybdd.core.pages.PageObject; import
 * net.serenitybdd.junit.runners.SerenityRunner; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * @RunWith(SerenityRunner.class) public class SerenityGmailTest extends
 * PageObject {
 * 
 * @Managed(driver = "chrome") WebDriver driver=new ChromeDriver();
 * 
 * @Title("Executing Login Test")
 * 
 * @Test public void doLogin() {
 * 
 * // Open the Gmail login page
 * getDriver().get("https://accounts.google.com/signin");
 * 
 * // Explicit wait for the identifier input field WebDriverWait wait = new
 * WebDriverWait(getDriver(), Duration.ofSeconds(10));
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId"
 * ))) .sendKeys("trainer@way2automation.com");
 * 
 * // Click on the Next button
 * find(By.xpath("//*[@id='identifierNext']/span/span")).click();
 * 
 * // Wait for the password field to be visible wait.until(
 * ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//*[@id='password']/div[1]/div/div[1]/input")))
 * .sendKeys("trainer@way2automation");
 * 
 * // Add sleep to observe the test (optional) try { Thread.sleep(3000); } catch
 * (InterruptedException e) { e.printStackTrace(); } } }
 */
/*
 * package testcases; import org.junit.Test;
 * 
 * import static java.time.temporal.ChronoUnit.SECONDS;
 * 
 * import java.time.Duration;
 * 
 * import org.junit.runner.RunWith; import org.openqa.selenium.By; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.openqa.selenium.support.FindBy;
 * 
 * 
 * //import io.appium.java_client.gecko.GeckoDriver; import
 * net.serenitybdd.annotations.Managed; import
 * net.serenitybdd.annotations.Title; import
 * net.serenitybdd.core.pages.PageObject; import
 * net.serenitybdd.core.pages.WebElementFacade; import
 * net.serenitybdd.junit.runners.SerenityRunner;
 * 
 * @RunWith(SerenityRunner.class)
 * 
 * 
 * public class SerenityGmailTest extends PageObject{
 * 
 * @Managed(driver="chrome") WebDriver driver=new ChromeDriver(); //WebDriver
 * driver=new FirefoxDriver();
 * 
 * 
 * 
 * @Title("Ëxecuting Login Test")
 * 
 * @Test public void doLogin() {
 * 
 * open();
 * 
 * System.out.println(getImplicitWaitTimeout());
 * System.out.println(getWaitForTimeout()); setImplicitTimeout(10,SECONDS);
 * System.out.println(getImplicitWaitTimeout());
 * 
 * setImplicitTimeout(10,SECONDS);
 * find(By.id("identifierId")).sendKeys("trainer@way2automation.com");
 * find(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
 * withTimeoutOf(Duration.ofSeconds(10)).find(By.xpath(
 * "//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(
 * "trainer@way2automation"); try { Thread.sleep(3000); } catch
 * (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * }
 * 
 * }
 * 
 */