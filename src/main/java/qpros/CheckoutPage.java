package qpros;

import com.github.javafaker.Faker;
import net.andreinc.mockneat.unit.types.Ints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutPage {

  public static void checkout() {
    WebDriver driver = new ChromeDriver();
    WebElement placeOrder_name = driver.findElement(By.id("name"));
    WebElement placeOrder_country = driver.findElement(By.id("country"));
    WebElement placeOrder_city = driver.findElement(By.id("city"));
    WebElement placeOrder_card = driver.findElement(By.id("card"));
    WebElement placeOrder_month = driver.findElement(By.id("month"));
    WebElement placeOrder_year = driver.findElement(By.id("year"));
    WebElement placeOrder_btn = driver.findElement(
      By.xpath("//button[normalize-space()='Purchase']")
    );

    Faker faker = new Faker();
    String fakeName = faker.name().firstName();
    String fakeCountry = faker.address().country();
    String fakeCity = faker.address().city();
    String fakeCard = faker.finance().creditCard();
    String fakeMonth = Ints.ints().range(1, 12).toString();
    String fakeYear = Ints.ints().range(2023, 2030).toString();

    placeOrder_name.sendKeys(fakeName);
    placeOrder_country.sendKeys(fakeCountry);
    placeOrder_city.sendKeys(fakeCity);
    placeOrder_card.sendKeys(fakeCard);
    placeOrder_month.sendKeys(fakeMonth);
    placeOrder_year.sendKeys(fakeYear);
    placeOrder_btn.click();
  }
}
