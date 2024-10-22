package com.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen {
    By btnStart = By.id("btnStart");
    By btnCompare = By.id("btnCompare");

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public CalculatorScreen touchEmiCalculatorBtn() {
        waitForElement(btnStart);
        getWebElement(btnStart).click();
        waitForElement(By.id("etLoanAmount"));
        return getInstance(CalculatorScreen.class);
    }

    public CompareLoanScreen touchCompareLoanBtn() {
        waitForElement(btnCompare);
        getWebElement(btnCompare).click();
        return getInstance(CompareLoanScreen.class);
    }

    public boolean EmiCalculatorBtn() {
        waitForElement(btnStart);
        return getWebElements(btnStart).size() > 0;
    }

    public boolean EmiCompareLoansBtn() {
        waitForElement(btnCompare);
        return getWebElements(btnCompare).size() > 0;
    }
}
