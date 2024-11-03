package com.juaracoding.pages;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 10/20/2024 2:02 AM
@Last Modified 10/20/2024 2:02 AM
Version 1.0
*/

import com.juaracoding.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    private WebDriver driver;


    public ProductsPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement btnAddToCart2;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement txtCartBadge;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement btnRemove;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement btnSearch;


    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Onesie']")
    private WebElement etalaseOnesie;

    @FindBy(xpath = " //div[@class='inventory_details_name large_size']")
    private WebElement txtEtalaseOnesie;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement btnBack;



    public void setSelect(){
        Select select = new Select(btnSearch);
        select.selectByIndex(2);
    }

    public void setEtalaseOnesie(){
        etalaseOnesie.click();
    }

    public void clickAddToCart2(){
        btnAddToCart2.click();
    }

    public void clickBtnBack(){
        btnBack.click();
    }

    public void clickAddToCart(){
        btnAddToCart.click();
    }

    public void clickBtnRemove(){
        btnRemove.click();
    }

    public String getTxtCartBadge(){
        return txtCartBadge.getText();
    }

    public String getTxtEtalaseOnesie(){
        return txtEtalaseOnesie.getText();
    }
}
