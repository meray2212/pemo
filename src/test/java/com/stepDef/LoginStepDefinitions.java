package com.stepDef;

import com.base.BaseClass;
import com.page.LoginPage;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepDefinitions {

  public class LoginStep extends BaseClass {

    private WebDriver driver;
    private LoginPage loginPage;

    //Implementing all d step from feature file

    @Given("Open Pemo login page")
    public void openPemoLoginPage() {
      System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
      driver = new ChromeDriver();
      driver.get("https://app.pemo.io/");
      loginPage = new LoginPage(driver);
    }

    @When("Enter valid credentials")
    public void enterValidCredentials() {
      loginPage.login("meraywafik@pemo.com", "Candidate@123");
    }

    @When("Click on the login button")
    public void clickLoginButton() {
      loginPage.clickLoginButton();
    }

    @Then("Verify successful login")
    public void verifySuccessfulLogin() {
      Assert.assertEquals(driver.getTitle(), "Pemo");
    }
  }
}
