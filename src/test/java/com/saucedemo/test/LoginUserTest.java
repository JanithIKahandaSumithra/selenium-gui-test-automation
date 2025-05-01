package com.saucedemo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class LoginUserTest {

    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void setUp() {

        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();

        loginPage = new LoginPage();
    }

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
}
