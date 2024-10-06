package TestNGHomeTasks;

import Listener.ExtentManager;
import com.epam.tat.module4.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestNGHomeTask
{
    static Calculator calculator = new Calculator();
    ExtentReports extent=new ExtentReports();
    static ExtentTest test;

    @BeforeMethod
    public void setupTest() {
        ExtentTest test = ExtentManager.getExtentReports().createTest("Test Case: " + Thread.currentThread().getId());
        ExtentManager.setTest(test);
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }

    @AfterClass
    public void tearDownClass() {
        extent.flush();
    }

    // Positive Tests
    @Test(groups = "positive",description = "Adding two positive integers.")
    public void testSumPositive() {
        test = ExtentManager.getExtentReports().createTest("Adding two positive integers.");
        try {
            long result = calculator.sum(5, 3);
            Assert.assertEquals(result, 8, "5 + 3 should be 8");
            test.pass("Adding two positive integers : 5 + 3 did give the result 8");
        }
        catch (AssertionError e)
        {
            test.fail("Adding two positive integers : 5 + 3 did not give the result 8 ");
        }
        finally {
            extent.flush();
        }
    }


    @Test(groups = "positive",description = "Subtracting two positive integers")
    public void testSubtractionPositive() {
        test=ExtentManager.getExtentReports().createTest("Subtracting two positive integers");

        try {
            long result = calculator.sub(10, 4);
            Assert.assertEquals(result, 6, "10 - 4 should be 6");
            test.pass("Subtracting two positive integers : 10 - 4 did give the result 6");
        }
        catch (AssertionError e)
        {
            test.fail("Subtracting two positive integers : 10 - 4 did not give the result 6 ");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "positive",description = "Multiply two positive integers.")
    public void testMultiplicationPositive() {
        test=ExtentManager.getExtentReports().createTest("Multiply two positive integers.");

        try{
            long result = calculator.mult(5, 4);
            Assert.assertEquals(result, 20, "5 * 4 should be 20");
            test.pass("Multiply two positive integers : 5 * 4 did give the result 20");
        }
        catch (AssertionError e)
        {
            test.fail("Multiply two positive integers : 5 * 4 did not give the result 20");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "positive",description = "Divide two positive integers.")
    public void testDivisionPositive() {
        test = ExtentManager.getExtentReports().createTest("Divide two positive integers.");
        try
        {
            long result = calculator.div(20, 4);
            Assert.assertEquals(result, 5, "20 / 4 should be 5");
            test.pass("Divide two positive integers : 20 / 4 did give the result 5");
        }
            catch (AssertionError e)
        {
            test.fail("Divide two positive integers : 20 / 4 did not give the result 5");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "positive",description = "Positive integer exponentant calculation.",dependsOnMethods = "testSumPositive")
    public void testPowerPositive() {
        test=ExtentManager.getExtentReports().createTest("Positive integer exponentant calculation");
        try
        {
            double result = calculator.pow(2, 3);
            Assert.assertEquals(result, 8.0, "2^3 should be 8");
            test.pass("Positive integer exponentant calculation : 2^3 did give the result 8");
        }
        catch (AssertionError e)
        {
            test.fail("Positive integer exponentant calculation : 2^3 did not give the result 8");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "negative", description = "Division by zero.",expectedExceptions = NumberFormatException.class)
    public void testDivisionByZero() {
        test=ExtentManager.getExtentReports().createTest("Division by zero.");
        calculator.div(10, 0);
    }

    @Test(groups = "positive",description = "Subtracting two positive integers to get a negative result.")
    public void testSubtractionNegativeResult() {
        test=ExtentManager.getExtentReports().createTest("Subtracting two positive integers to get a negative result");
        try
        {
            long result = calculator.sub(5, 10);
            Assert.assertEquals(result, -5, "5 - 10 should be -5");
            test.pass("Subtracting two positive integers to get a negative result : 5 - 10 did give the result -5");
        }
        catch (AssertionError e)
        {
            test.fail("Subtracting two positive integers to get a negative result : 5 - 10 did not give the result -5");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "positive", description = "Multiplication by zero.")
    public void testMultiplicationByZero() {
        test=ExtentManager.getExtentReports().createTest("Multiplication by zero.");

        try
        {
            long result = calculator.mult(5, 0);
            Assert.assertEquals(result, 0, "5 * 0 should be 0");
            test.pass("Multiplication by zero. : 5 * 0 did give the result 0");
        }
        catch (AssertionError e)
        {
            test.fail("Multiplication by zero. : 5 * 0 did not give the result 0");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "negative",description = "Negative exponential power.",expectedExceptions = IllegalArgumentException.class)
    public void testNegativeExponent() {
        test= ExtentManager.getExtentReports().createTest("Negative exponential power.");
        calculator.pow(2, -2);  // Assuming a negative exponent should throw an exception.
    }

    // Parameterized test using DataProvider
    @Test(dataProvider = "additionDataProvider", groups = "positive",description = "Addition of integers with parameterized data.")
    public void testAdditionParameterized(long a, long b, long expected) {
        test=ExtentManager.getExtentReports().createTest("Addition of integers with parameterized data.");
        try{
            Assert.assertEquals(calculator.sum(a, b), expected, "Addition result mismatch");
            test.pass("Addition of integers with parameterized data : "+a+" + "+b+" did give the result "+Math.addExact(a,b));
        }
        catch (AssertionError e)
        {
            test.fail("Addition of integers with parameterized data : "+a+" + "+b+" did not give the result "+Math.addExact(a,b));
        }
        finally {
            extent.flush();
        }
    }

    @DataProvider(name = "additionDataProvider")
    public Object[][] additionData() {
        return new Object[][]{
                {1, 2, 3},
                {0, 5, 5},
                {10, 10, 20}
        };
    }

    @Test(groups = "negative" ,description = "Test sum method for large long numbers (edge case for overflow)", expectedExceptions = ArithmeticException.class)
    public void testSumOverflow() {
        test=ExtentManager.getExtentReports().createTest("Test sum method for large long numbers (edge case for overflow)");
        try{
            long result = calculator.sum(Long.MAX_VALUE, 1);  // Potential overflow case
            Assert.fail("Overflow should have occurred but didn't.");
            test.fail("Overflow should have occurred but didn't.");
        }
        catch (AssertionError e)
        {
            test.fail("Overflow has occurred.");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "negative" ,description="Test division by zero for floating-point numbers")
    public void testDivByZeroDouble() {
        test=ExtentManager.getExtentReports().createTest("Test division by zero for floating-point numbers");
        try{

            double result = calculator.div(10.0, 0.0);
            Assert.assertTrue(Double.isInfinite(result), "Division by 0 should return Infinity");
            test.pass("Test division by zero for floating-point numbers is infinity");
        }
            catch (AssertionError e)
        {
            test.fail("Test division by zero for floating-point numbers is not infinity.");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "positive" ,description="Test square root of negative numbers")
    public void testSquareRootNegative() {
        test=ExtentManager.getExtentReports().createTest("Test square root of negative numbers");
        try{
            double result = calculator.sqrt(-16.0);
            Assert.assertEquals(result, 4.0, "Square root of negative number is incorrectly handled");
            test.pass("Square root of negative number is correctly handled");
        }
        catch (AssertionError e)
        {
            test.fail("Square root of negative number is incorrectly handled");
        }
        finally {
            extent.flush();
        }
    }

    @Test(groups = "negative" ,description="Test cosine implementation (cos() should not call sin()")
    public void testCosineFunction() {
        test=ExtentManager.getExtentReports().createTest("Test cosine implementation (cos() should not call sin()");
        double result = calculator.cos(Math.PI / 2); // cos(π/2) should be close to 0
        Assert.assertNotEquals(result, Math.sin(Math.PI / 2), "Cosine incorrectly calls sine");
        Assert.assertEquals(result, Math.cos(Math.PI / 2), "Cosine calculation is incorrect");
    }

    @Test(groups = "negative" ,description="est cotangent function (cotangent uses tanh instead of 1/tan)")
    public void testCotangentFunction() {
        test=ExtentManager.getExtentReports().createTest("est cotangent function (cotangent uses tanh instead of 1/tan)");
        double result = calculator.ctg(Math.PI / 4); // cot(π/4) should be 1
        Assert.assertNotEquals(result, Math.tanh(Math.PI / 4), "Cotangent function incorrectly uses tanh");
        Assert.assertEquals(result, 1.0, "Cotangent function is incorrect");
    }

    @Test(groups = "negative" ,description="Test tangent function for invalid angles (tan(90) should throw error or return large value)")
    public void testTangentFunctionAtNinetyDegrees() {
        test=ExtentManager.getExtentReports().createTest("Test tangent function for invalid angles (tan(90) should throw error or return large value)");
        double result = calculator.tg(Math.PI / 2); // tan(90 degrees) should be undefined or very large
        Assert.assertTrue(Double.isInfinite(result) || Math.abs(result) > 10000, "Tangent of 90 degrees should be undefined or large");
    }

    @Test(groups = "negative" ,description="Test multiplication for double precision (method should not use floor)")
    public void testDoubleMultiplicationPrecision() {
        test=ExtentManager.getExtentReports().createTest("Test multiplication for double precision (method should not use floor)");
        double result = calculator.mult(2.5, 3.2); // Expecting precise result without floor
        Assert.assertEquals(result, 8.0, "Double multiplication should not use Math.floor()");
    }

    @Test(groups = "negative" ,description="Test negative exponent in pow (should return fractional values, not floored)")
    public void testPowerWithNegativeExponent() {
        test=ExtentManager.getExtentReports().createTest("Test negative exponent in pow (should return fractional values, not floored)");
        double result = calculator.pow(2, -2);  // 2^-2 should return 0.25, but method floors the exponent
        Assert.assertEquals(result, 0.25, "Power function does not handle negative exponents correctly");
    }

    @Test(groups = "negative" ,description="Test invalid input for pow (fractional exponent should be handled correctly)")
    public void testPowerWithFractionalExponent() {
        test=ExtentManager.getExtentReports().createTest("Test invalid input for pow (fractional exponent should be handled correctly)");
        double result = calculator.pow(4, 0.5);  // 4^0.5 should be 2, but method floors the exponent
        Assert.assertEquals(result, 2.0, "Power function does not handle fractional exponents correctly");
    }

    @Test(groups = "negative" ,description="Parameterized tests for isPositive with boundary cases",dataProvider = "isPositiveDataProvider")
    public void testIsPositive(long input, boolean expected) {
        test=ExtentManager.getExtentReports().createTest("Parameterized tests for isPositive with boundary cases");
        try{
        boolean result = calculator.isPositive(input);
        Assert.assertEquals(result, expected, "isPositive function has correct behavior");
            test.pass("isPositive function has correct behavior : "+input+" did give the result "+result);
        }
        catch (AssertionError e)
        {
            test.fail("isPositive function has incorrect behavior : "+input+" did give the result ");
        }
        finally {
            extent.flush();
        }
    }

    @DataProvider(name = "isPositiveDataProvider")
    public Object[][] isPositiveData() {
        return new Object[][]{
                {0, false},      // boundary case
                {1, true},       // positive number
                {-1, false},     // negative number
        };
    }

    @Test(groups = "negative" ,description="Parameterized tests for isNegative with boundary cases",dataProvider = "isNegativeDataProvider")
    public void testIsNegative(long input, boolean expected) {
        test=ExtentManager.getExtentReports().createTest("Parameterized tests for isNegative with boundary cases");

        try
        {
            boolean result = calculator.isNegative(input);
            Assert.assertEquals(result, expected, "isNegative function has correct behavior");

            test.pass("isNegative function has correct behavior : "+input+" did give the result "+result);
        }
            catch (AssertionError e)
        {
            test.fail("isNegative function has incorrect behavior : "+input+" did give the result ");
        }
        finally {
            extent.flush();
        }
    }

    @DataProvider(name = "isNegativeDataProvider")
    public Object[][] isNegativeData() {
        return new Object[][]{
                {0, false},      // boundary case
                {1, false},      // positive number
                {-1, true},      // negative number
        };
    }
}

