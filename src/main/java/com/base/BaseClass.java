package com.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

  public static void main(String[] args) {}

  public static void launchDriver() {
    System.setProperty("webdriver.chrome.driver", "X://chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://app.pemo.io/");
    driver.manage().window().maximize();

    log.info("::::Maximizing Window::::");
    driver.manage().window().maximize();
  }

  public static Logger log = LogManager.getLogger(BaseClass.class.getName());

  public static void tearDown() {
    WebDriver driver = new ChromeDriver();
    driver.quit();
    log.info("::::Browser Closed::::");
    log.info("::::Active Browser is close::::");
  }
}
