package com.juaracoding.utils;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 11/1/2024 3:58 PM
@Last Modified 11/1/2024 3:58 PM
Version 1.0
*/

public enum ScenarioTests {

    //list deskripsi scenario //untuk membuat extence report
    //T1-Sampai habis

    T1("Login dengan Username dan password yang valid"),
    T2("Login dengan Username dan Password salah"),
    T3("Login dengan Username kosong"),
    T4("Login dengan Password kosong"),
    T5("Add to cart"),
    T6("Remove from cart"),
    T7("Successful Checkout"),
    T8("Checkout Empaty Cart"),
    T9("Leave the first name section blank"),
    T10("Leave the last name section blank"),
    T11("Leave the Zip Code section blank");


    private String scenarioTestName;

    ScenarioTests(String value) {
        scenarioTestName = value;
    }

    public String getScenarioTestName() {
        return scenarioTestName;
    }

}
