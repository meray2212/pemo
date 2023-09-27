package qpros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPage {

  public static void addToCart() {
    WebDriver driver = new ChromeDriver();

    WebElement cartButton = driver.findElement(By.id("cartur"));
    WebElement placeOrderButton = driver.findElement(
      By.xpath("//button[normalize-space()='Place Order']")
    );

    cartButton.click();
    placeOrderButton.click();
  }

  public void removeFromCart() {
    WebDriver driver = new ChromeDriver();
    WebElement cartButton = driver.findElement(By.id("cartur"));
    WebElement removeButton = driver.findElement(
      By.xpath("//a[normalize-space()='Delete']")
    );
    cartButton.click();
    removeButton.click();
  }
}
/*enahanced */
// integrate data faker
