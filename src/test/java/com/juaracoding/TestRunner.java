package com.juaracoding;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 10/30/2024 2:05 PM
@Last Modified 10/30/2024 2:05 PM
Version 1.0
*/

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/main/resources/features/001LoginPositif.feature",
        "src/main/resources/features/002LoginNegatif.feature",
        "src/main/resources/features/003Cart.feature",
        "src/main/resources/features/004Checkout.feature"},
        glue = "com.juaracoding",
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}

