package qpros;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Checkout_E2E_Tests {

  Faker faker = new Faker();
  String fakeEmail = faker.internet().emailAddress();
  String fakePassword = faker.internet().password();

  @Test
  public void Regression() {
    SignUpPage.signUp(fakeEmail, fakePassword);
    loginPage.login(fakeEmail, fakePassword);
    HomePage.checkCategoriesForItems();
    CartPage.addToCart();
  }
}
