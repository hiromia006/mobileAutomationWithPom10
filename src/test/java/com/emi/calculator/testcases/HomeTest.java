package com.emi.calculator.testcases;

import com.emi.calculator.screens.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    HomeScreen homeScreen;

    @Test
    public void verifyEmiCalculatorBtnShouldSucceed() {
        homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.EmiCalculatorBtn());
    }

    @Test
    public void verifyCompareLoansBtnShouldSucceed() {
        homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.EmiCompareLoansBtn());
    }
}
