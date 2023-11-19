package com.page;

import static org.hamcrest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoicesPage {

  private WebDriver driver;
  private By invoiceStatusColumn = By.cssSelector(
    "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > div:nth-child(1) > span:nth-child(2)"
  );
  private By invoiceFileNameColumn = By.xpath(
    "//span[normalize-space()='Meray Assignment (1)']"
  );
  private By submittedByColumn = By.xpath("//td[@class='submitted-by']");
  private By rejectReasonColumn = By.id("NymCardInvoices-reject-1");
  private By uploadButton = By.xpath("//button[text()='Upload']");
  private By invoicesLink = By.linkText(
    "https://testmeraycompany.pemo.io/invoices-management/invoices/"
  );
  private By chooseFileInput = By.xpath("//input[@id='file']");
  private By submitButton = By.xpath("//button[text()='Submit']");
  private By actionsButton = By.xpath(
    "//tbody/tr[1]/td[8]/button[1]/button[1]"
  );
  private By reject_option = By.xpath("//a[contains(text(), 'Reject')]");
  private By allTab = By.cssSelector("#NymCardInvoices-allInvoicesTab-1");
  private By rejectionReasonField = By.xpath(
    "//input[@placeholder='Add your comment here']"
  );
  private By toastMessage;
  private String expectedToastMessage;
  private By footerNumber;
  By archiveTab;
  By rejectedTab;

  public InvoicesPage(WebDriver driver2) {}

  //Step1
  public void navigateToInvoicesPage() {
    driver.findElement(invoicesLink).click();
  }

  // step2

  private boolean isInvoiceWithCriteriaPresent(String status, String fileName) {
    // Implement logic to check if an invoice with specific criteria is present in the 'All' tab

    List<WebElement> statusElements = driver.findElements(invoiceStatusColumn);
    List<WebElement> fileNameElements = driver.findElements(
      invoiceFileNameColumn
    );

    // Iterate through the elements and check if there is a match
    for (int i = 0; i < statusElements.size(); i++) {
      String currentStatus = statusElements.get(i).getText();
      String currentFileName = fileNameElements.get(i).getText();
      if (currentStatus.equals(status) && currentFileName.equals(fileName)) {
        return true;
      }
    }
    return false;
    // You may need to enhance this logic based on your actual application behavior

  }

  public void uploadInvoiceWithPDFName(String fileName) {
    driver.findElement(uploadButton).click();
    driver.findElement(chooseFileInput).sendKeys("path/to/invoice/" + fileName);
    driver.findElement(submitButton).click();
  }

  public void waitForInvoiceStatusChange(String fileName, String targetStatus) {
    // logic to wait for the invoice status to change to the target status
    WebDriverWait wait = new WebDriverWait(driver, 10);

    // Assuming that the status column contains the current status of each invoice
    By statusLocator = By.xpath(
      "//td[@class='status'][text()='" + targetStatus + "']"
    );

    wait.until(
      ExpectedConditions.textToBePresentInElementLocated(
        statusLocator,
        targetStatus
      )
    );
    // You may need to enhance this logic based on your actual application behavior
  }

  // Add other methods as needed based on your application's behavior

  private void refreshPage() {
    driver.navigate().refresh();
  }

  //Step4
  public void clickActionsButtonForInvoice(String status, String fileName) {
    // logic to click the 'Actions' button for a specific invoice

    List<WebElement> statusElements = driver.findElements(invoiceStatusColumn);
    List<WebElement> fileNameElements = driver.findElements(
      invoiceFileNameColumn
    );
    List<WebElement> actionsButtons = driver.findElements(actionsButton);

    // Iterate through the elements and click the 'Actions' button for the matching invoice
    for (int i = 0; i < statusElements.size(); i++) {
      String currentStatus = statusElements.get(i).getText();
      String currentFileName = fileNameElements.get(i).getText();
      if (currentStatus.equals(status) && currentFileName.equals(fileName)) {
        actionsButtons.get(i).click();
        break; // Break the loop after clicking the 'Actions' button
      }
    }
  }

  //Step 5: Click on 'Reject' option

  public void clickRejectOption() {
    ((WebElement) reject_option).click();
  }

  public void navigateToAllTab() {
    driver.findElement(allTab).click();
  }

  public void checkAllTabForInvoice(String status, String fileName) {
    navigateToAllTab();

    if (isInvoiceWithCriteriaPresent(status, fileName)) {
      clickActionsButtonForInvoice(status, fileName);
      clickRejectOption();
      enterRejectionReason("Invalid Info");
      clickRejectOption();
      // Wait for the toast message to appear
      isToastMessageDisplayed(expectedToastMessage);

      refreshPage();
    } else {
      uploadInvoiceWithPDFName(fileName);
      waitForInvoiceStatusChange(fileName, "Review");
      clickActionsButtonForInvoice("Review", fileName);
      clickRejectOption();
      enterRejectionReason("Invalid Info");
      clickRejectOption();

      // Wait for the toast message to appear
      isToastMessageDisplayed(expectedToastMessage);
    }
  }

  public boolean isToastMessageDisplayed(String expectedToastMessage) {
    WebElement toastElement = driver.findElement(toastMessage);

    // Check if the toast message is present and visible
    return (
      toastElement.isDisplayed() &&
      toastElement.getText().contains(expectedToastMessage)
    );
  }

  public void enterRejectionReason(String reason) {
    driver.findElement(rejectionReasonField).sendKeys(reason);
  }

  public void verifyInvoiceRecordDisappearedFromAllTab() {
    // Implement verification for the disappearance of the Invoice record from the 'All' tab
    By invoiceRecord = By.xpath(
      "//td[@class='file-name'][contains(text(),'Meray Invoice')]"
    );
    assertThat(driver.findElements(invoiceRecord).isEmpty());
  }

  public void verifyNumbersMatched() {
    // Implement verification for the matched numbers
    String numberAllTab = driver.findElement(By.id("all-tab-number")).getText();
    String numberFooter = driver.findElement(footerNumber).getText();
    int countAllTabRows = driver
      .findElements(By.xpath("//table[@id='all-tab']/tbody/tr"))
      .size();

    Assert.assertEquals(numberAllTab, numberFooter);
    assertEquals(numberAllTab, String.valueOf(countAllTabRows));
  }

  public void verifyInvoiceRecordAppearedInArchive() {
    // Implement verification for the appearance of the Invoice record in the 'Archive' page under 'Rejected' tab
    navigateToArchiveTab();
    By invoiceRecord = By.xpath(
      "//td[@class='file-name'][contains(text(),'Meray Invoice')]"
    );
    assertTrue(driver.findElements(invoiceRecord).size() > 0);
  }

  public void verifyInvoiceStatusIsRejected() {
    // Implement verification for the Invoice Status being 'Rejected'
    By invoiceStatus = By.xpath(
      "//td[@class='status'][contains(text(),'Rejected')]"
    );
    assertTrue(driver.findElements(invoiceStatus).size() > 0);
  }

  public void verifyNumbersMatchedInRejectedTab() {
    // Implement verification for the matched numbers in the 'Rejected' tab
    navigateToRejectedTab();
    String numberRejectedTab = driver
      .findElement(By.id("rejected-tab-number"))
      .getText();
    String numberFooter = driver.findElement(footerNumber).getText();
    int countRejectedTabRows = driver
      .findElements(By.xpath("//table[@id='rejected-tab']/tbody/tr"))
      .size();

    assertEquals(numberRejectedTab, numberFooter);
    assertEquals(numberRejectedTab, String.valueOf(countRejectedTabRows));
  }

  public void verifySubmittedByColumnContainsUploaderName() {
    // Implement verification for the 'Submitted by' column
    By submittedByColumn = By.xpath("//td[@class='submitted-by']");
    String uploaderName = getUserFullName(); // You need to implement this method to get the uploader's full name

    for (WebElement element : driver.findElements(submittedByColumn)) {
      assertEquals(uploaderName, element.getText());
    }
  }

  public void verifyRejectionReasonAppearsInAuditTrail() {
    // Implement verification for the Audit Trail
    navigateToRejectedTab();
    By auditTrailLink = By.xpath("//a[contains(text(),'Audit Trail')]");
    driver.findElement(auditTrailLink).click();

    By rejectionReason = By.xpath(
      "//div[@class='audit-trail']/p[contains(text(),'Invalid Info')]"
    );
    assertTrue(driver.findElements(rejectionReason).size() > 0);
  }

  // Existing code...

  private void navigateToArchiveTab() {
    driver.findElement(archiveTab).click();
  }

  private void navigateToRejectedTab() {
    driver.findElement(rejectedTab).click();
  }

  private String getUserFullName() {
    // Implement logic to get the logged-in user's full name
    // This might involve retrieving the name from the application after login
    return "Meray Wafik"; // Replace with actual logic
  }
}
