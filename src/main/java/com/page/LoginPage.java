package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

  private WebDriver driver;
  private By emailField = By.id("signIn-1");
  private By passwordField = By.id("signIn-2");
  private By loginButton = By.cssSelector("button[type='submit']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void login(String email, String password) {
    driver.findElement(emailField).sendKeys(email);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
  }

  public void enterEmail(String email) {
    driver.findElement(emailField).sendKeys(email);
  }

  public void enterPassword(String password) {
    driver.findElement(passwordField).sendKeys(password);
  }

  public void clickLoginButton() {
    driver.findElement(loginButton).click();
  }

  public String getPageTitle() {
    return driver.getTitle();
  }
}
