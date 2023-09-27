package qpros;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends SignUpPage {

  public static void checkCategoriesForItems() {
    WebDriver driver = new ChromeDriver();

    // Find the parent element that contains the category links
    WebElement categoriesParent = driver.findElement(
      By.xpath("//div[@class='list-group']")
    );

    // Find all the category links within the parent element
    List<WebElement> categoryLinks = categoriesParent.findElements(
      By.id("itemc")
    );

    // Loop over the category links and print their text
    for (WebElement categoryLink : categoryLinks) {
      String categoryName = categoryLink.getText();
      System.out.println("Category: " + categoryName);

      // Perform any desired actions for each category
      // For example, click on the category link
      categoryLink.click();
    }
  }
}
