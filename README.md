# Selenium GUI Test Automation for SauceDemo

This project automates the **SauceDemo** website using **Selenium WebDriver**, **TestNG**, and **Java**. It includes a suite of tests that simulate user login and add-to-cart functionality for various products on the website. The tests also validate expected behavior using assertions.

## Features

- **Login Automation**: Automates user login using valid credentials.
- **Product Page Automation**: Automates adding multiple products (backpack, t-shirt, fleece jacket) to the cart.
- **Cart Page Validation**: Validates cart messages after adding products.
- **Page Object Model (POM)**: Uses POM design pattern to manage test automation code for better maintainability.

## Technologies Used

- **Selenium WebDriver**: For automating the browser interactions.
- **TestNG**: For structuring and running tests.
- **Java**: Programming language used for test automation.
- **Page Object Model (POM)**: A design pattern used for organizing test scripts.
- **ChromeDriver**: For running tests on Chrome browser.



## How it Works

1. **LoginPage.java**: Contains methods to interact with the login page. It includes functions to set the username, password, and click the login button.
   
2. **ProductPage.java**: Contains methods to add products (backpack, t-shirt, fleece jacket) to the cart. It validates the presence of product buttons and interacts with them.

3. **CartPage.java**: After adding products to the cart, this class validates the cart message and ensures the user is redirected to the correct page.

4. **TestApp.java**: A utility class that manages the WebDriver, opens and closes the browser, and provides helper methods for interacting with web elements (e.g., waiting for elements to appear).

5. **PropertyFileReader.java**: A utility class to read values from `.properties` files for maintaining element locators in a centralized manner.

6. **Test Classes**: The test classes, `LoginUserTest.java` and `ProductPageTest.java`, validate the login functionality and the product page functionality using TestNG.

## Example Test

Here is an example of a test that validates the login functionality:

```java
@Test
public void testNewUserLogin() {
    productPage = loginPage
            .setUserName("standard_user")
            .setPassword("secret_sauce")
            .login();

    String actualMessage  = productPage.getSalutationMessage();
    String expectedMessage = "Products";
    Assert.assertEquals(actualMessage,expectedMessage,"Failed Login Test");
}


