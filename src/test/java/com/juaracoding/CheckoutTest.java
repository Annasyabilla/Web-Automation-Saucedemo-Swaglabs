package com.juaracoding;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 11/3/2024 5:37 PM
@Last Modified 11/3/2024 5:37 PM
Version 1.0
*/

import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductsPage;
import com.juaracoding.utils.Utils;
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

public class CheckoutTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private static WebDriver driver;
    private  static ExtentTest extentTest;
    private static ProductsPage productsPage = new ProductsPage();
    private static CheckoutPage checkoutPage = new CheckoutPage();


    public CheckoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User back to home")
    public void user_back_to_home(){
        Utils.delay(2);
        checkoutPage.clickBtnBackHome();
        extentTest.log(LogStatus.PASS,"User back to home");

    }

    @When("Click on the cart badge")
    public void click_on_the_cart_badge(){
        Utils.delay(2);
        checkoutPage.clickCart();
        extentTest.log(LogStatus.PASS,"Click on the cart badge");
    }

    @And("Click on the Check out button")
    public void click_on_the_Check_out_button(){
        Utils.delay(2);
        checkoutPage.clickCheckout();
        extentTest.log(LogStatus.PASS,"Click on the Check out button");
    }

    @And("Fill First name")
    public void fill_first_name(){
        Utils.delay(2);
        checkoutPage.firstName("John");
        extentTest.log(LogStatus.PASS,"Fill First name");
    }

    @And("Fill Last Name")
    public void fill_last_name(){
        Utils.delay(2);
        checkoutPage.lastName("Smith");
        extentTest.log(LogStatus.PASS,"Fill Last Name");
    }

    @And("Fill Postal Code")
    public void fill_postal_code(){
        Utils.delay(2);
        checkoutPage.postalCode("43567");
        extentTest.log(LogStatus.PASS,"Fill Postal Code");
    }

    @And("Click Continue")
    public void click_Continue(){
        Utils.delay(2);
        checkoutPage.clickBtnContinue();
        extentTest.log(LogStatus.PASS,"Click Continue");
    }

    @And("Click Finish")
    public void click_Finish(){
        Utils.delay(2);
        checkoutPage.clickFinish();
        extentTest.log(LogStatus.PASS,"Click Finish");
    }

    @Then("User redirected to complate order page")
    public void user_redirected_to_complate_order_page(){
        Utils.delay(2);
        Assert.assertEquals(checkoutPage.getTxtFinishTitle(),"Thank you for your order!");
        extentTest.log(LogStatus.PASS,"User redirected to complate order page");
    }

    @Then("Showing error message empaty cart can not to processed")
    public void showing_error_message_cart_can_not_to_processed(){
        Utils.delay(2);
//        Assert.assertEquals(checkoutPage.getTxtCheckoutTitle(),"Empty cart : you can't processed to to next step");
        if(checkoutPage.getTxtCheckoutTitle().equals(String.valueOf("Empty cart : you can't processed to to next step"))){
            extentTest.log(LogStatus.PASS, "Showing error message empaty cart can not to processed");
        }else{extentTest.log(LogStatus.FAIL, "Showing error message empaty cart can not to processed");
        }
//        extentTest.log(LogStatus.PASS,"Showing error message empaty cart can not to processed");
    }

    @Given("leave the first name section blank")
    public void leave_the_first_name_section_blank(){
        Utils.delay(2);
        checkoutPage.clearElementFirstName();
        checkoutPage.firstName("");
        extentTest.log(LogStatus.PASS,"leave the first name section blank");
    }

    @When("leave the last name section blank")
    public void leave_the_last_name_section_blank(){
        Utils.delay(2);
        checkoutPage.clearElementLastName();
        checkoutPage.lastName("");
        extentTest.log(LogStatus.PASS,"leave the last name section blank");
    }

    @And("Leave the ZIP code section blank")
    public void leave_the_ZIP_code_section_blank(){
        Utils.delay(2);
        checkoutPage.clearElementPostalCode();
        checkoutPage.postalCode("");
        extentTest.log(LogStatus.PASS,"Leave the ZIP code section blank");
    }

    @Then("Showing error message First Name is required")
    public void showing_error_message_FirstName_is_required(){
        Utils.delay(2);
        Assert.assertEquals(checkoutPage.getTxtFirstNameIsRequired(),"Error: First Name is required");
        extentTest.log(LogStatus.PASS,"Showing error message First Name is required");
    }

    @Then("Showing error message Last Name is required")
    public void showing_error_message_LastName_is_required(){
        Utils.delay(2);
        Assert.assertEquals(checkoutPage.getTxtLastNameIsRequired(),"Error: Last Name is required");
        extentTest.log(LogStatus.PASS,"Showing error message Last Name is required");
    }

    @Then("Showing error message Postal Code is required")
    public void showing_error_message_PostalCode_is_required(){
        Utils.delay(2);
        Assert.assertEquals(checkoutPage.getTxtPostalCodeIsRequired(), "Error: Postal Code is required");
        extentTest.log(LogStatus.PASS,"Showing error message Postal Code is required");
    }


}
