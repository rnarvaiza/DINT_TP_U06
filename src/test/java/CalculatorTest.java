import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Rafa Narvaiza
 * @version 1.0
 *
 * {@code Calculator } Is a collection of tests for {@link Calculator} designed to verify whether
 * math operations are working correctly.
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {


    Calculator calculator = new Calculator();

    private static final String EXCEPTION_MESSAGE = "You enter a unsupported operation";
    private static final String UNRECOGNIZE_OPERATOR = "$";
    private static final double NUMBER_WITH_ZERO_VALUE = 0;
    private static final double NUMBER_WITH_POSITIVE_VALUE_1 = 1;
    private static final double NUMBER_WITH_POSITIVE_VALUE_2 = 2;
    private static final double NUMBER_WITH_POSITIVE_VALUE_3 = 3;
    private static final double NUMBER_WITH_NEGATIVE_VALUE_1 = -1;
    private static final double NUMBER_WITH_NEGATIVE_VALUE_2 = -2;


    @BeforeEach
    public void setUp(){
        System.out.println("@BeforeEach is executed before each test");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("@AfterEach is executed after each test");
    }

    @BeforeAll
    public static void setup(){
        System.out.println("@BeforeAll is executed once at the beginning of the class");
    }

    @AfterAll
    public static void teardown(){
        System.out.println("@AfterAll is executed once at the end of the class");
    }


    @Test
    @Order(1)
    @DisplayName("Testing add operator with two number")
    public void testCheckAddOperatorWithTwoNumber(){
        System.out.println("Test 1");
        assertEquals(NUMBER_WITH_POSITIVE_VALUE_3, calculator.calculator(Calculator.ADD_OPERATOR, NUMBER_WITH_POSITIVE_VALUE_1, NUMBER_WITH_POSITIVE_VALUE_2));
    }

    @Test
    @Order(2)
    @DisplayName("Testing subtract operator with two number positives")
    public void testCheckSubtractOperatorWithTwoNumberPositive(){
        System.out.println("Test 2");
        assertEquals(NUMBER_WITH_POSITIVE_VALUE_1, calculator.calculator(Calculator.SUBTRACT_OPERATOR, NUMBER_WITH_POSITIVE_VALUE_2, NUMBER_WITH_POSITIVE_VALUE_1));
    }

    @Test
    @Order(3)
    @DisplayName("Testing subtract operator with two number negatives")
    public void testCheckSubstractOperatorWithTwoNumberNegative(){
        System.out.println("Test 3");
        assertEquals(NUMBER_WITH_POSITIVE_VALUE_1, calculator.calculator(Calculator.SUBTRACT_OPERATOR, NUMBER_WITH_NEGATIVE_VALUE_1, NUMBER_WITH_NEGATIVE_VALUE_2));
    }

    @Test
    @Order(4)
    @DisplayName("Testing multiplication operator")
    public void testCheckMultiplicationOperator(){
        System.out.println("Test 4");
        assertEquals(NUMBER_WITH_POSITIVE_VALUE_3, calculator.calculator(Calculator.MULTIPLY_OPERATOR, NUMBER_WITH_POSITIVE_VALUE_3, NUMBER_WITH_POSITIVE_VALUE_1));
    }

    @Test
    @Order(5)
    @DisplayName("Testing multiplication operator with num1 = 0")
    public void testCheckMultiplicationOperatorWithFirstNumberEqualsToZero(){
        System.out.println("Test 5");
        assertEquals(NUMBER_WITH_ZERO_VALUE, calculator.calculator(Calculator.MULTIPLY_OPERATOR, NUMBER_WITH_ZERO_VALUE, NUMBER_WITH_POSITIVE_VALUE_3));
    }

    @Test
    @Order(6)
    @DisplayName("Testing multiplication operator with num1 = 0 and num2 = 0")
    public void testCheckMultiplicationOperatorWithBothNumbersEqualsZero(){
        System.out.println("Test 6");
        assertEquals(NUMBER_WITH_ZERO_VALUE, calculator.calculator(Calculator.MULTIPLY_OPERATOR, NUMBER_WITH_ZERO_VALUE, NUMBER_WITH_ZERO_VALUE));
    }

    @Test
    @Order(7)
    @DisplayName("Testing divide operator")
    public void testCheckDivideOperator(){
        System.out.println("Test 7");
        assertEquals(NUMBER_WITH_POSITIVE_VALUE_3, calculator.calculator(Calculator.DIVIDER_OPERATOR, NUMBER_WITH_POSITIVE_VALUE_3, NUMBER_WITH_POSITIVE_VALUE_1));
    }

    @Test
    @Order(8)
    @DisplayName("Testing divide operator with num1 = 0")
    public void testCheckDivideOperatorWithFirstNumberEqualsZero(){
        System.out.println("Test 8");
        assertEquals(NUMBER_WITH_ZERO_VALUE, calculator.calculator(Calculator.DIVIDER_OPERATOR, NUMBER_WITH_ZERO_VALUE, NUMBER_WITH_POSITIVE_VALUE_3));
    }

    @Test
    @Order(9)
    @DisplayName("Testing divide operator with num2 = 0")
    public void testCheckDivideOperatorWithSecondNumberEqualsZero(){
        System.out.println("Test 9");
        boolean isInfinity = Double.isInfinite(calculator.calculator(Calculator.DIVIDER_OPERATOR, NUMBER_WITH_POSITIVE_VALUE_3, NUMBER_WITH_ZERO_VALUE));
        assertTrue(isInfinity);
    }

    @Test
    @Order(10)
    @DisplayName("Testing divide operator with num1 = 0 and num2 =0")
    public void testCheckDivideOperatorWithBothNumbersEqualsZero(){
        System.out.println("Test 10");
        boolean isNan = Double.isNaN(calculator.calculator(Calculator.DIVIDER_OPERATOR, NUMBER_WITH_ZERO_VALUE, NUMBER_WITH_ZERO_VALUE));
        assertTrue(isNan);
    }


    @Test
    @Order(10)
    @DisplayName("Testing calculator method with operator different to +, -, *, /")
    public void testCheckUnrecognizedOperator(){
        System.out.println("Test 11");
        try{
            calculator.calculator(UNRECOGNIZE_OPERATOR, NUMBER_WITH_NEGATIVE_VALUE_2, NUMBER_WITH_POSITIVE_VALUE_3);
            fail();
        }catch (UnsupportedOperationException e){
            final String expected = "You enter a unsupported operation";
            Assertions.assertEquals(expected, EXCEPTION_MESSAGE, e.getMessage());
        }

    }

}
