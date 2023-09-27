# Selenium Java Automation Framework

This automation framework is built using Selenium WebDriver with Java. It provides automated tests for the following functionalities:

1. Register and Login
   - Automated tests for user registration and login functionalities.
   - Verify the registration and login processes are successful.
   - Use valid and invalid test data to cover different scenarios.

2. Category Verification
   - Verify that the listed categories have items available.
   - Navigate through the categories and validate the presence of items.
   - Use assertions to ensure the correct number of items are displayed.

3. Add Random Item to Cart
   - Select a random item from the available items in a category.
   - Add the item to the cart.
   - Verify that the item is added successfully by checking the cart contents.

4. Remove Item from Cart
   - Remove a specific item from the cart.
   - Validate that the item is removed from the cart and the cart is empty.

5. Complete Successful Checkout with Random Item
   - Select a random item from the available items in a category.
   - Add the item to the cart.
   - Proceed to the checkout process.
   - Enter shipping and payment details.
   - Validate that the checkout process is completed successfully.

## Pre-requisites

1. Java Development Kit (JDK) - Ensure Java is installed and configured on your system.
2. Selenium WebDriver - Set up Selenium WebDriver and configure the necessary drivers (e.g., ChromeDriver).
3. TestNG or JUnit - Install the test framework of your choice (TestNG or JUnit).

## Getting Started

1. Clone the repository to your local machine.
2. Set up your development environment with the required dependencies.
3. Configure the Selenium WebDriver and ensure the driver executable is in the system's PATH.
4. Open the project in your preferred IDE.
5. Update the configuration files or properties with the necessary URLs, credentials, etc.
6. Run the tests using the test framework command or IDE integration.

## Project Structure

The project structure follows a standard Maven project structure:

- `src/main/java`: Contains the framework code, including page objects, utilities, and configuration files.
- `src/test/java`: Contains the automated tests for different functionalities.
- `src/test/resources`: Contains test data, configuration files, and other resources.
- `pom.xml`: Maven configuration file for managing project dependencies.

## Test Execution

To execute the tests, you can use the following options:

1. Run tests from your IDE:
   - Right-click on the test suite or test class.
   - Select the "Run" or "Run As" option based on your IDE.
   
2. Run tests using TestNG or JUnit command-line:
   - Use the appropriate test framework command to execute the tests.
   - For TestNG: `mvn test` or `mvn surefire:test`.
   - For JUnit: `mvn test` or `mvn surefire:test`.

## Reporting

The framework generates test reports for better visibility and analysis. The reports can be found in the following directory after test execution: