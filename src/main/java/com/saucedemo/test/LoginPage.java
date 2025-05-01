package com.saucedemo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyFileReader;
import utils.TestApp;

public class LoginPage {

    WebDriver driver = TestApp.getInstance().getDriver();
    PropertyFileReader prop = new PropertyFileReader();

    String userNameElementValue = prop.getProperty("LoginPage","user.name.element");
    String passwordElementValue = prop.getProperty("LoginPage","password.element");
    String loginButtonElementValue = prop.getProperty("LoginPage","login.button.element");

    public LoginPage setUserName(String userNameValue){
        TestApp.getInstance().waitUntilNextElementAppears(By.id(userNameElementValue),15);
        WebElement userNameElement = driver.findElement(By.id(userNameElementValue));
        userNameElement.sendKeys(userNameValue);
        return this;
    }

    public LoginPage setPassword(String passwordValue){
        TestApp.getInstance().waitUntilNextElementAppears(By.id(passwordElementValue),15);
        WebElement passwordElement = driver.findElement(By.id(passwordElementValue));
        passwordElement.sendKeys(passwordValue);
        return this;
    }

    public ProductPage login(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id(loginButtonElementValue),15);
        WebElement loginButtonElement = driver.findElement(By.id(loginButtonElementValue));
        loginButtonElement.click();
        return new ProductPage();
    }

}
