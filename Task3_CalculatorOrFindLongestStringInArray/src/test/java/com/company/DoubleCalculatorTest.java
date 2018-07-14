package com.company;


import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleCalculatorTest {

    @Test
    public void testCalculate() {
        Assert.assertEquals(32.0, DoubleCalculator.calculate('*', 8, 4), "Результат умножения неверный;");
        Assert.assertEquals(2.0, DoubleCalculator.calculate('/', 8, 4), "Результат деления неверный;");
        Assert.assertEquals(12.0, DoubleCalculator.calculate('+', 8, 4), "Результат сложения неверный;");
        Assert.assertEquals(4.0, DoubleCalculator.calculate('-', 8, 4), "Результат вычитания неверный;");

    }
}
