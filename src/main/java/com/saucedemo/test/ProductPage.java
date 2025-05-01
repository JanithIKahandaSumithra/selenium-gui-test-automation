package com.saucedemo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyFileReader;
import utils.TestApp;

public class ProductPage {

    WebDriver driver = TestApp.getInstance().getDriver();
    PropertyFileReader prop = new PropertyFileReader();
    String salutationMessageElement = prop.getProperty("ProductPage","salutation.message.element");
    String backpackProductButtonElementValue = prop.getProperty("ProductPage","backpack.product.button.element");
    String tshirtProductButtonElementValue = prop.getProperty("ProductPage","tshirt.product.button.element");
    String redtshirtProductButtonElementValue = prop.getProperty("ProductPage","redtshirt.product.button.element");
    String addtocartButtonElementValue = prop.getProperty("ProductPage","addtocart.button.element");

    public String getSalutationMessage(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(salutationMessageElement),15);
        String actualMessage = driver.findElement(By.xpath(salutationMessageElement)).getText();
        return actualMessage;

    }

    public ProductPage backpackAddtoCart(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id(backpackProductButtonElementValue),15);
        WebElement backpackButtonElement = driver.findElement(By.id(backpackProductButtonElementValue));
        backpackButtonElement.click();
        return this;
    }

    public ProductPage tshirtAddtoCart(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id(tshirtProductButtonElementValue),15);
        WebElement tshirtButtonElement = driver.findElement(By.id(tshirtProductButtonElementValue));
        tshirtButtonElement.click();
        return this;
    }

    public ProductPage redtshirtAddtoCart(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id(redtshirtProductButtonElementValue),15);
        WebElement redtshirtButtonElement = driver.findElement(By.id(redtshirtProductButtonElementValue));
        redtshirtButtonElement.click();
        return this;
    }

    public CartPage addtocart(){
        TestApp.getInstance().waitUntilNextElementAppears(By.className(addtocartButtonElementValue),15);
        WebElement addtocartElement = driver.findElement(By.className(addtocartButtonElementValue));
        addtocartElement.click();
        return new CartPage();

    }









}
