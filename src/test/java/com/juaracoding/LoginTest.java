package com.juaracoding;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 11/3/2024 2:19 PM
@Last Modified 11/3/2024 2:19 PM
Version 1.0
*/

import com.juaracoding.pages.LoginPage;
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

public class LoginTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private static WebDriver driver;
    private  static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Go to the login page")
    public void go_to_login_page() {
        driver.manage().window().maximize(); //untuk full screen
        driver.get("https://www.saucedemo.com/");
        extentTest.log(LogStatus.PASS,"Go to the login page");
    }

    @When("Enter the valid Username")
    public void enter_valid_username() {
        loginPage.username("standard_user");
        extentTest.log(LogStatus.PASS,"Enter the valid Username");
    }

    @And("Enter the valid Password")
    public void enter_valid_password() {
        loginPage.password("secret_sauce");
        extentTest.log(LogStatus.PASS,"Enter the valid Password");
    }

    @And("Click the login button")
    public void click_login_button() {
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS,"Click the login button");
    }

    @When("Enter the wrong Username")
    public void enter_wrong_username() {
        loginPage.username("standard");
        extentTest.log(LogStatus.PASS,"Enter the wrong Username");
    }

    @And("Enter the wrong Password")
    public void enter_wrong_password() {
        loginPage.password("sauce");
        extentTest.log(LogStatus.PASS,"Enter the wrong Password");
    }

    @When("Leave the Username blank")
    public void leave_the_username_blank() {
        loginPage.clearElementUsername();
        loginPage.username("");
        extentTest.log(LogStatus.PASS,"Leave the Username blank");
    }

    @And("Leave the Password blank")
    public void leave_the_password_blank() {
//        loginPage.clearElementPassword();
        loginPage.password("");
        extentTest.log(LogStatus.PASS,"Leave the Password blank");
    }

    @Then("user redirected to home page")
    public void user_redirected_to_home_page() {
        Assert.assertEquals(loginPage.getProductsTitle(),"Products");
        extentTest.log(LogStatus.PASS,"user redirected to home page");
    }

    @Then("showing error message Username and password do not match")
    public void showing_error_message_username_and_password_do_not_match() {
        Assert.assertEquals(loginPage.getInvLogin(),"Epic sadface: Username and password do not match any user in this service");
        extentTest.log(LogStatus.PASS,"showing error message Username and password do not match");
    }

    @Then("showing error message Username is required")
    public void showing_error_message_username_is_required() {
        Assert.assertEquals(loginPage.getNullUsername(),"Epic sadface: Username is required");
        extentTest.log(LogStatus.PASS,"showing error message Username is required");
    }

    @Then("showing error message Password is required")
    public void showing_error_message_password_is_required() {
        Assert.assertEquals(loginPage.getNullPassword(),"Epic sadface: Password is required");
        extentTest.log(LogStatus.PASS,"showing error message Password is required");
    }
}
