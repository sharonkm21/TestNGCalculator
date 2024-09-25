package TestNGHomeTasks;

import com.epam.tat.module4.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNGHomeTask
{
    private Calculator calculator;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUpClass() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
        test = extent.createTest("Calculator Test");
    }

    @AfterMethod
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
        long result = calculator.sum(5, 3);
        Assert.assertEquals(result, 8, "5 + 3 should be 8");
    }

    @Test(groups = "positive",description = "Subtracting two positive integers")
    public void testSubtractionPositive() {
        long result = calculator.sub(10, 4);
        Assert.assertEquals(result, 6, "10 - 4 should be 6");
    }

    @Test(groups = "positive",description = "Multiply two positive integers.")
    public void testMultiplicationPositive() {
        long result = calculator.mult(5, 4);
        Assert.assertEquals(result, 20, "5 * 4 should be 20");
    }

    @Test(groups = "positive",description = "Divide two positive integers.")
    public void testDivisionPositive() {
        long result = calculator.div(20, 4);
        Assert.assertEquals(result, 5, "20 / 4 should be 5");
    }

    @Test(groups = "positive",description = "Positive integer exponentant calculation.",dependsOnMethods = "testSumPositive")
    public void testPowerPositive() {
        double result = calculator.pow(2, 3);
        Assert.assertEquals(result, 8.0, "2^3 should be 8");
    }

    // Negative Tests
    @Test(groups = "negative", description = "Division by zero.",expectedExceptions = NumberFormatException.class)
    public void testDivisionByZero() {
        calculator.div(10, 0);
    }

    @Test(groups = "positive",description = "Subtracting two positive integers to get a negative result.")
    public void testSubtractionNegativeResult() {
        long result = calculator.sub(5, 10);
        Assert.assertEquals(result, -5, "5 - 10 should be -5");
    }

    @Test(groups = "positive", description = "Multiplication by zero.")
    public void testMultiplicationByZero() {
        long result = calculator.mult(5, 0);
        Assert.assertEquals(result, 0, "5 * 0 should be 0");
    }

    @Test(groups = "negative",description = "Negative exponential power.",expectedExceptions = IllegalArgumentException.class)
    public void testNegativeExponent() {
        calculator.pow(2, -2);  // Assuming a negative exponent should throw an exception.
    }

    // Parameterized test using DataProvider
    @Test(dataProvider = "additionDataProvider", groups = "positive",description = "Addition of integers with parameterized data.")
    public void testAdditionParameterized(long a, long b, long expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "Addition result mismatch");
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
        long result = calculator.sum(Long.MAX_VALUE, 1);  // Potential overflow case
        Assert.fail("Overflow should have occurred but didn't.");
    }

    @Test(groups = "negative" ,description="Test division by zero for floating-point numbers")
    public void testDivByZeroDouble() {
        double result = calculator.div(10.0, 0.0);
        Assert.assertTrue(Double.isInfinite(result), "Division by 0 should return Infinity");
    }

    @Test(groups = "positive" ,description="Test square root of negative numbers")
    public void testSquareRootNegative() {
        double result = calculator.sqrt(-16.0);
        Assert.assertEquals(result, 4.0, "Square root of negative number is incorrectly handled");
    }

    @Test(groups = "negative" ,description="Test cosine implementation (cos() should not call sin()")
    public void testCosineFunction() {
        double result = calculator.cos(Math.PI / 2); // cos(π/2) should be close to 0
        Assert.assertNotEquals(result, Math.sin(Math.PI / 2), "Cosine incorrectly calls sine");
        Assert.assertEquals(result, Math.cos(Math.PI / 2), "Cosine calculation is incorrect");
    }

    @Test(groups = "negative" ,description="est cotangent function (cotangent uses tanh instead of 1/tan)")
    public void testCotangentFunction() {
        double result = calculator.ctg(Math.PI / 4); // cot(π/4) should be 1
        Assert.assertNotEquals(result, Math.tanh(Math.PI / 4), "Cotangent function incorrectly uses tanh");
        Assert.assertEquals(result, 1.0, "Cotangent function is incorrect");
    }

    @Test(groups = "negative" ,description="Test tangent function for invalid angles (tan(90) should throw error or return large value)")
    public void testTangentFunctionAtNinetyDegrees() {
        double result = calculator.tg(Math.PI / 2); // tan(90 degrees) should be undefined or very large
        Assert.assertTrue(Double.isInfinite(result) || Math.abs(result) > 10000, "Tangent of 90 degrees should be undefined or large");
    }

    @Test(groups = "negative" ,description="Test multiplication for double precision (method should not use floor)")
    public void testDoubleMultiplicationPrecision() {
        double result = calculator.mult(2.5, 3.2); // Expecting precise result without floor
        Assert.assertEquals(result, 8.0, "Double multiplication should not use Math.floor()");
    }

    @Test(groups = "negative" ,description="8. Test negative exponent in pow (should return fractional values, not floored)")
    public void testPowerWithNegativeExponent() {
        double result = calculator.pow(2, -2);  // 2^-2 should return 0.25, but method floors the exponent
        Assert.assertEquals(result, 0.25, "Power function does not handle negative exponents correctly");
    }

    @Test(groups = "negative" ,description="Test invalid input for pow (fractional exponent should be handled correctly)")
    public void testPowerWithFractionalExponent() {
        double result = calculator.pow(4, 0.5);  // 4^0.5 should be 2, but method floors the exponent
        Assert.assertEquals(result, 2.0, "Power function does not handle fractional exponents correctly");
    }

    @Test(groups = "negative" ,description="Parameterized tests for isPositive with boundary cases",dataProvider = "isPositiveDataProvider")
    public void testIsPositive(long input, boolean expected) {
        boolean result = calculator.isPositive(input);
        Assert.assertEquals(result, expected, "isPositive function has incorrect behavior");
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
        boolean result = calculator.isNegative(input);
        Assert.assertEquals(result, expected, "isNegative function has incorrect behavior");
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

