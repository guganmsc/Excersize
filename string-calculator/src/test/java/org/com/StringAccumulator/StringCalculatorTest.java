package org.com.StringAccumulator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.com.StringAccumulator.StringCalculator;

public class StringCalculatorTest {
    @Test
    public void calculateEmptyResult() {
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void calculateSingleNumber() {
        Assert.assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void calculateTwo_expectTwo() {
        Assert.assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void calculateTwoToOne_expectThree() {
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void calculateTwoToOneWithNewlines_expectThree() {
        Assert.assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void calculateTwoToOneWithCustomDelimiter_expectThree() {
        Assert.assertEquals(3, StringCalculator.add("//[;]\n2;1"));
    }
    
    //above
    
    @Test
    public void calculateSingleNegativeValue_exception() {
        try {
            StringCalculator.add("-1");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed (-1)", e.getMessage());
        }
    }

    @Test
    public void calculateTwoNegativeValue_exception() {
        try {
            StringCalculator.add("-1,-2");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed (-1,-2)", e.getMessage());
        }
    }
    
    @Test
    public void calculateTwoToOneThousandOne_Two() {
        Assert.assertEquals(2, StringCalculator.add("2,1001"));
    }
    
    @Test
    public void calculateCustomDelimiter_AnyLength() {
        Assert.assertEquals(6, StringCalculator.add("//[:::]\n2:::1:::3"));
    }

    @Test
    public void calculateMultipleCustomDelimiter_expectThree() {
        Assert.assertEquals(6, StringCalculator.add("//[;]|[%]\n1;2%3"));
    }

    @Test
    public void calculateTwoToOneWithCustomDelimiterWithLengthTwo_longer() {
        Assert.assertEquals(3, StringCalculator.add("//[xx]\n2xx1"));
    }

  
}



 
