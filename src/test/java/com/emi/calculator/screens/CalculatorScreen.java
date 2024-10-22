package com.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalculatorScreen extends BaseScreen {
    public CalculatorScreen(AndroidDriver driver) {
        super(driver);
    }

    public CalculatorScreen fillAmount(int amout) {
        getWebElement(By.id("etLoanAmount")).clear();
        getWebElement(By.id("etLoanAmount")).sendKeys(String.valueOf(amout));
        return this;
    }

    public CalculatorScreen fillInterest(float interest) {
        getWebElement(By.id("etInterest")).clear();
        getWebElement(By.id("etInterest")).sendKeys(String.valueOf(interest));
        return this;
    }

    public CalculatorScreen fillYears(int year) {
        getWebElement(By.id("etYears")).clear();
        getWebElement(By.id("etYears")).sendKeys(String.valueOf(year));
        return this;

    }

    public CalculatorScreen fillMonth(int month) {
        getWebElement(By.id("etMonths")).sendKeys(String.valueOf(month));
        return this;

    }

    public CalculatorScreen fillProcessFee(int fee) {
        getWebElement(By.id("etFee")).sendKeys(String.valueOf(fee));
        return this;

    }

    public CalculatorScreen touchCalculateBtn() {
        getWebElement(By.id("btnCalculate")).click();
        return this;
    }

    public CalculatorScreen touchResetBtn() {
        getWebElement(By.id("btnReset")).click();
        return this;
    }

    public boolean hasDetailBtn() {
        return getWebElements(By.id("btnDetail")).size() > 0;
    }

    public EmiDetailScreen touchDetailBtn() {
        getWebElement(By.id("btnDetail")).click();
        waitForElement(By.id("actionMenuBack"));
        return getInstance(EmiDetailScreen.class);
    }

    public boolean hasAmountElement() {
        return getWebElements(By.id("etLoanAmount")).size() > 0;
    }
}
