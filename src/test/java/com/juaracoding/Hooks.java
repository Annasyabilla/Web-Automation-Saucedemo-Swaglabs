package com.juaracoding;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 11/1/2024 2:18 PM
@Last Modified 11/1/2024 2:18 PM
Version 1.0
*/

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.ScenarioTests;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    static WebDriver driver;

    //untuk membuat extence report
    static ExtentTest extentTest;
    static ExtentReports reports = new ExtentReports("target/extent-report.html");

    @Before
    public static void setUp() {
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        ScenarioTests[] tests = ScenarioTests.values();
        extentTest = reports.startTest(tests[Utils.testCount].getScenarioTestName());
        Utils.testCount++;
    }

    @AfterStep //untuk screenshot
    public void getResultTest(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            String screenshotPath = Utils.getScreenshot(driver,scenario.getName()
                    .replace(" ","_"));
            extentTest.log(LogStatus.FAIL,scenario.getName()+"\n"
                    +extentTest.addScreenCapture(screenshotPath));
        }
    }

    @After
    public void endScenarioTest(){
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterAll
    public static void finish() {
        Utils.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}
