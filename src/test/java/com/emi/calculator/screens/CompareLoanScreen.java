package com.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CompareLoanScreen extends BaseScreen {
    By etLoanAmount1 = By.id("etLoanAmount1");

    public CompareLoanScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean hasLoanAmount1Field() {
        waitForElement(etLoanAmount1);
        return getWebElements(etLoanAmount1).size() > 0;
    }

    public CompareLoanScreen fillLoan1Amount(int amount) {
        waitForElement(etLoanAmount1);
        getWebElement(etLoanAmount1).sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanScreen fillLoan2Amount(int amount) {
        getWebElement(By.id("etLoanAmount2")).sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanScreen fillInterest1(float interest) {
        getWebElement(By.id("etInterest1")).sendKeys(String.valueOf(interest));
        return this;
    }

    public CompareLoanScreen fillInterest2(float interest) {
        getWebElement(By.id("etInterest2")).sendKeys(String.valueOf(interest));
        return this;
    }

    public CompareLoanScreen fillMonth1(int months) {
        getWebElement(By.id("etPeriod1")).sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoanScreen fillMonth2(int months) {
        getWebElement(By.id("etPeriod2")).sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoanScreen tapCalculateBtn() {
        getWebElement(By.id("btnCalculate")).click();
        return this;
    }

    public boolean hasCompareResultTable() {
        return getWebElements(By.id("layoutTable")).size() > 0;
    }

    public CompareLoanScreen tapResetBtn() {
        getWebElement(By.id("btnReset")).click();
        return this;

    }
}
