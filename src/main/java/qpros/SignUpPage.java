package qpros;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SignUpPage {

  public static void main(String[] args) {}

  public static void signUp(String username, String password) {
    System.setProperty(
      "webdriver.chrome.driver",
      "/Users/mwafik/Qpros/qpros/chromedriver"
    );

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    WebDriver driver = new ChromeDriver(chromeOptions);
    String url = "https://www.demoblaze.com/";
    driver.get(url);
    driver.manage().window().maximize();

    WebElement signupBtn = driver.findElement(By.id("signin2"));
    WebElement usernameField = driver.findElement(By.id("sign-username"));
    WebElement passwordField = driver.findElement(By.id("sign-password"));
    WebElement signUpButton = driver.findElement(
      By.xpath("//button[normalize-space()='Sign up']")
    );
    signupBtn.click();
    usernameField.sendKeys(username);
    passwordField.sendKeys(password);
    signUpButton.click();
  }
  // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  // Alert alert = driver.switchTo().alert();

  // ((JavascriptExecutor)driver).executeScript("window.confirm = function(msg){return true;};");

  //String alertText = alert.getText();
  // System.out.println("Alert Text: " + alertText);
  // alert.accept();

}
/*Enhanced version of the above code:*/
// separate driver and url for reuse
// Handle Alerts
