package com.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmiDetailScreen extends BaseScreen {
    By actionMenuBack = By.id("actionMenuBack");

    public EmiDetailScreen(AndroidDriver driver) {
        super(driver);
    }

    public CalculatorScreen touchBackBtn() {
        getWebElement(actionMenuBack).click();
        waitForElement(By.id("etLoanAmount"));
        return getInstance(CalculatorScreen.class);
    }

    public boolean hasBackBtn() {
        return getWebElements(actionMenuBack).size() > 0;
    }
}
