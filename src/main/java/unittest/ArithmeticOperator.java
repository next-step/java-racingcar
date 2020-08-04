package unittest;

public class ArithmeticOperator {

    String ADD_OPERATOR = "+";
    String SUBSTRACT_OPERATOR = "-";
    String MULTIPLY_OPERATOR = "*";
    String DIVIDE_OPERATOR = "/";

    public int calculateAAndB(int a, int b, String operator) {
        int result = 0;

        if(ADD_OPERATOR.equals(operator)) {
            result = add(a, b);
        }
        if(SUBSTRACT_OPERATOR.equals(operator)) {
            result = substract(a, b);
        }
        if(MULTIPLY_OPERATOR.equals(operator)) {
            result = multiply(a, b);
        }
        if(DIVIDE_OPERATOR.equals(operator)) {
            result = divide(a, b);
        }

        return result;
    }


    public int add(int a, int b) {

        return a + b;
    }


    public int substract(int a, int b) {
        return a - b;
    }


    public int multiply(int a, int b) {
        return a * b;
    }


    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isArithmeticiOperator(String operator) {
        boolean result = false;
        if(ADD_OPERATOR.equals(operator) || SUBSTRACT_OPERATOR.equals(operator)
                || MULTIPLY_OPERATOR.equals(operator) || DIVIDE_OPERATOR.equals(operator)) {
            result = true;
        }
        return result;
    }
}
