package com.stepDef;

import com.page.InvoicesPage;
import com.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvoiceSteps {

  private LoginPage loginPage;
  private InvoicesPage invoicesPage;
  private WebDriver driver;

  @Given("I am on the Pemo login page")
  public void iAmOnThePemoLoginPage() {
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    driver = new ChromeDriver();
    driver.get("https://app.pemo.io/");
    loginPage = new LoginPage(driver);
  }

  @When("I log in with valid credentials")
  public void iLogInWithValidCredentials() {
    loginPage.login("meraywafik@pemo.com", "Candidate@123");
  }

  @When("I navigate to the 'Invoices' page")
  public void iNavigateToInvoicesPage() {
    invoicesPage = new InvoicesPage(driver);
    invoicesPage.navigateToInvoicesPage();
  }

  @When(
    "I check the 'All' tab for an Invoice with Status 'Review' and file name 'Meray Invoice'"
  )
  public void iCheckAllTabForInvoice() {
    invoicesPage.checkAllTabForInvoice("Review", "Meray Invoice");
  }

  @When("I click on 'Actions' button related to the Invoice")
  public void iClickOnActionsButton() {
    invoicesPage.clickActionsButtonForInvoice("Review", "Meray Invoice");
  }

  @When("I click on 'Reject' option")
  public void iClickOnRejectOption() {
    invoicesPage.clickRejectOption();
  }

  @When("I enter rejection reason as {string}")
  public void iEnterRejectionReason(String rejectionReason) {
    invoicesPage.enterRejectionReason(rejectionReason);
  }

  @When("I click on 'Reject Invoice' button")
  public void iClickOnRejectInvoiceButton() {
    invoicesPage.clickRejectOption();
  }

  @Then("a toast message should appear with text {string}")
  public void toastMessageShouldAppear(String expectedToastMessage) {
    // Implement verification for the toast message
    assertTrue(invoicesPage.isToastMessageDisplayed(expectedToastMessage));
  }

  @Then("the Invoice record should disappear from the 'All' tab")
  public void invoiceRecordShouldDisappearFromAllTab() {
    // Implement verification for the disappearance of the Invoice record
    invoicesPage.verifyInvoiceRecordDisappearedFromAllTab();
  }

  @Then(
    "the number beside the 'All' tab, the number in the Footer, and the count of rows in the 'All' tab should be matched"
  )
  public void numbersShouldBeMatched() {
    // Implement verification for the matched numbers
    invoicesPage.verifyNumbersMatched();
  }

  @Then(
    "the Invoice record should appear in the 'Archive' page under 'Rejected' tab in the First Row"
  )
  public void invoiceRecordShouldAppearInArchive() {
    // Implement verification for the appearance of the Invoice record in the 'Archive' page
    invoicesPage.verifyInvoiceRecordAppearedInArchive();
  }

  @Then("the Invoice Status should be 'Rejected'")
  public void invoiceStatusShouldBeRejected() {
    // Implement verification for the Invoice Status being 'Rejected'
    invoicesPage.verifyInvoiceStatusIsRejected();
  }

  @Then(
    "the number beside the 'Rejected' tab, the number in the Footer, and the number of Records should be matched"
  )
  public void numbersShouldBeMatchedInRejectedTab() {
    // Implement verification for the matched numbers in the 'Rejected' tab
    invoicesPage.verifyNumbersMatchedInRejectedTab();
  }

  @Then(
    "the 'Submitted by' column should contain Uploader First Name + Last Name"
  )
  public void submittedByColumnShouldContainUploaderName() {
    // Implement verification for the 'Submitted by' column
    invoicesPage.verifySubmittedByColumnContainsUploaderName();
  }

  @Then(
    "from 'Archive' page → 'Rejected' tab → Invoice Details → Audit Trail: The entered rejection reason should be appearing"
  )
  public void rejectionReasonShouldAppearInAuditTrail() {
    // Implement verification for the Audit Trail
    invoicesPage.verifyRejectionReasonAppearsInAuditTrail();
  }
}
