/**
 *
 * The {@code Calculator} simple calculator which can perform basic arithmetic operations like addition, subtraction, multiplication or division.
 *
 * @author JJReina
 * @version 0.1
 *
 */
public final class Calculator {

    protected static final String ADD_OPERATOR = "+";
    protected static final String SUBTRACT_OPERATOR = "-";
    protected static final String MULTIPLY_OPERATOR = "*";
    protected static final String DIVIDER_OPERATOR = "/";
    private static final String EXCEPTION_MESSAGE = "You enter a unsupported operation ";

    /**
     * Default constructor
     */
    public Calculator() {}

    /**
     * @param operator the {@code String} to use as operation: {@value ADD_OPERATOR}, {@value SUBTRACT_OPERATOR}, {@value MULTIPLY_OPERATOR}, {@value DIVIDER_OPERATOR}. Any other character will throw a {@code UnsupportedOperationException}
     * @param num1 the {@code int} to use as first value of the operation.
     * @param num2 the {@code int} to use as second value of the operation.
     * @return a double as result of the operation: {@value ADD_OPERATOR}, {@value SUBTRACT_OPERATOR}, {@value MULTIPLY_OPERATOR}, {@value DIVIDER_OPERATOR}
     */
    public double calculator(String operator, double num1, double num2) {
        double result;
        switch (operator) {
            case ADD_OPERATOR:
                result = add (num1, num2);
                break;
            case SUBTRACT_OPERATOR:
                result = subtract (num1, num2);
                break;
            case MULTIPLY_OPERATOR:
                result = multiply (num1, num2);
                break;
            case DIVIDER_OPERATOR:
                result = divide (num1, num2);
                break;
            default:
                throw new UnsupportedOperationException( EXCEPTION_MESSAGE + operator);
        }
        return result;
    }

    private double add(double num1, double num2) {
        return num1 + num2;
    }

    private double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private double divide(double num1, double num2) {
        return num1 / num2;
    }
}