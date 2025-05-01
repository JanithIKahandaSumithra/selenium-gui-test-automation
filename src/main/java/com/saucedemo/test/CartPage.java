package com.saucedemo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

public class CartPage {

    WebDriver driver = TestApp.getInstance().getDriver();
    PropertyFileReader prop = new PropertyFileReader();

    String cartSalutationMessageElement = prop.getProperty("CartPage","cart.salutation.message.element");

    public String getCartSalutationMessage(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(cartSalutationMessageElement),15);
        String actualcartMessage = driver.findElement(By.xpath(cartSalutationMessageElement)).getText();
        return actualcartMessage;

    }

}
