package com.emi.calculator.testcases;

import com.emi.calculator.screens.CalculatorScreen;
import com.emi.calculator.screens.EmiDetailScreen;
import com.emi.calculator.screens.HomeScreen;
import com.emi.calculator.util.General;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {
    CalculatorScreen calculator;
    EmiDetailScreen detailScreen;

    @Test(priority = 0)
    public void checkEmiCalculatorScreen() {
        calculator = screen.getInstance(HomeScreen.class)
                .touchEmiCalculatorBtn();
        Assert.assertTrue(calculator.hasAmountElement());
    }

    @Test(priority = 1, dataProvider = "getData")
    public void calculateEmiShouldSucceed(String amount, String interestRate, String year) {
        calculator = calculator
                .fillAmount(Integer.valueOf(amount.replaceAll(".0", "").trim()))
                .fillInterest(Float.valueOf(interestRate))
                .fillYears(Integer.valueOf(year.replaceAll(".0", "").trim()))
                .fillMonth(5)
                .fillProcessFee(2)
                .touchCalculateBtn();
        Assert.assertTrue(calculator.hasDetailBtn());
    }

    @Test(priority = 2)
    public void resetEmiCalculatorScreen() {
        calculator = calculator
                .touchResetBtn();
        Assert.assertFalse(calculator.hasDetailBtn());
    }

    @Test(priority = 3, enabled = false)
    public void checkEmiCalculatorDetailShouldSucceed() {
        EmiDetailScreen detailScreen = calculator
                .fillAmount(1000000)
                .fillInterest(7.5f)
                .fillYears(3)
                .fillMonth(5)
                .fillProcessFee(2)
                .touchCalculateBtn()
                .touchDetailBtn();
        Assert.assertTrue(detailScreen.hasBackBtn());
    }


    @DataProvider//(name = "keya")
    public Object[][] getData() {
        return General.getTestData("Sheet1");
    }

    @Test(priority = 5)
    public void checkEBackBtnlShouldSucceed() {
        calculator = detailScreen
                .touchBackBtn();
        Assert.assertTrue(calculator.hasAmountElement());
    }
}
