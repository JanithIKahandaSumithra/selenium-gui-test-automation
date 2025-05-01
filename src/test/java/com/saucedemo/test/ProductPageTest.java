package com.saucedemo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class ProductPageTest {

    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {

        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();

        loginPage = new LoginPage();
    }

    @Test
    public void testProductPage() {
        productPage = loginPage
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .login();

        String actualMessage  = productPage.getSalutationMessage();
        String expectedMessage = "Products";
        Assert.assertEquals(actualMessage,expectedMessage,"Failed Login Test");

        cartPage = productPage
                .backpackAddtoCart()
                .tshirtAddtoCart()
                .redtshirtAddtoCart()
                .addtocart();

        String actualCartMessage  = cartPage.getCartSalutationMessage();
        String expectedcartMessage = "Your Cart";
        Assert.assertEquals(actualCartMessage,expectedcartMessage,"Failed Cart Test");
    }

    }


