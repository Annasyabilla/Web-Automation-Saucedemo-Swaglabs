package com.juaracoding.pages;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 10/23/2024 5:28 PM
@Last Modified 10/23/2024 5:28 PM
Version 1.0
*/

import com.juaracoding.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;


    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement btnCart;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement txtCheckout;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement btnCheckout;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtCheckoutTitle;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement btnContinue;


    @FindBy(xpath = " //span[@class='title']")
    private WebElement txtOverview;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement btnFinish;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement txtFinishTitle;


    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement btnBackHome;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtFirstNameIsRequired;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtLastNameIsRequired;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtPostalCodeIsRequired;


    public String getTxtFirstNameIsRequired(){
        return txtFirstNameIsRequired.getText();
    }

    public String  getTxtLastNameIsRequired(){
        return txtLastNameIsRequired.getText();
    }

    public String  getTxtPostalCodeIsRequired(){
        return txtPostalCodeIsRequired.getText();
    }

    public void clearElementFirstName(){
        this.firstName.clear();
    }

    public void clearElementLastName(){
        this.lastName.clear();
    }

    public void clearElementPostalCode(){
        this.postalCode.clear();
    }

    public void clickCart(){
        btnCart.click();
    }

    public void clickBtnBackHome(){
        btnBackHome.click();
    }

    public String getTxtCheckout(){
        return txtCheckout.getText();
    }

    public void clickCheckout(){
        btnCheckout.click();
    }

    public String getTxtCheckoutTitle(){
        return txtCheckoutTitle.getText();
    }

    public void formOrder(String firstName, String lastName, String postalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
        this.btnContinue.click();
    }

    public void firstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void lastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void postalCode(String postalCode){
        this.postalCode.sendKeys(postalCode);
    }

    public void clickBtnContinue(){
        btnContinue.click();
    }


    public String getTxtOverview(){
        return txtOverview.getText();
    }

    public void clickFinish(){
        btnFinish.click();
    }

    public String getTxtFinishTitle(){
        return txtFinishTitle.getText();
    }
}
