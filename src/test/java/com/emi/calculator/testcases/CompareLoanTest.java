package com.emi.calculator.testcases;

import com.emi.calculator.screens.CompareLoanScreen;
import com.emi.calculator.screens.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareLoanTest extends BaseTest {
    CompareLoanScreen loanScreen;

    @Test(priority = 0)
    public void checkCompareScreen() {
        loanScreen = screen.getInstance(HomeScreen.class)
                .touchCompareLoanBtn();
        Assert.assertTrue(loanScreen.hasLoanAmount1Field());
    }

    @Test(priority = 1)
    public void compareLoanShouldSucceed() {
        loanScreen = loanScreen
                .fillLoan1Amount(500000)
                .fillInterest1(8.0f)
                .fillMonth1(15)
                .fillLoan2Amount(500000)
                .fillInterest2(9f)
                .fillMonth2(15)
                .tapCalculateBtn();
        Assert.assertTrue(loanScreen.hasCompareResultTable());
    }

    @Test(priority = 2)
    public void compareLoanResetShouldSucceed() {
        loanScreen = loanScreen
                .tapResetBtn();
        Assert.assertFalse(loanScreen.hasCompareResultTable());
    }
}
