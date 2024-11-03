package com.juaracoding;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 11/3/2024 4:19 PM
@Last Modified 11/3/2024 4:19 PM
Version 1.0
*/

import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductsPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class CartTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private static WebDriver driver;
    private  static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static ProductsPage productsPage = new ProductsPage();

    public CartTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User login")
    public void user_login(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.LoginUser("standard_user", "secret_sauce");
        extentTest.log(LogStatus.PASS,"User login");
    }

    @When("Click the add to cart button on the first product")
    public void click_the_add_to_cart_button_on_the_first_product(){
        productsPage.clickAddToCart();
        extentTest.log(LogStatus.PASS,"Click the add to cart button on the first product");
    }

    @And("Click the add to cart button on the second product")
    public void click_the_add_to_cart_button_on_the_second_product(){
        productsPage.clickAddToCart2();
        extentTest.log(LogStatus.PASS,"Click the add to cart button on the second product");
    }

    @Then("The cart icon is marked with a cart badge into 2")
    public void The_cart_icon_is_marked_with_a_cart_badge_into_2(){
        Assert.assertEquals(productsPage.getTxtCartBadge(), "2");
        extentTest.log(LogStatus.PASS,"The cart icon is marked with a cart badge into 2");
    }

}
