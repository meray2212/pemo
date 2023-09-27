package qpros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPage extends SignUpPage {

  public static void login(String username, String password) {
    WebDriver driver = new ChromeDriver();

    WebElement loginHeader = driver.findElement(By.id("login2"));
    WebElement loginUserName = driver.findElement(By.id("loginusername"));
    WebElement loginPassword = driver.findElement(By.id("loginpassword"));
    WebElement logInBtn = driver.findElement(
      By.xpath("//button[normalize-space()='Log in']")
    );

    loginHeader.click();
    loginUserName.sendKeys(username);
    loginPassword.sendKeys(password);
    logInBtn.click();
  }
}
/* To Be done :*/
//Handle alerts
