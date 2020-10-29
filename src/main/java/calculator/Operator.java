package calculator;

public class Operator {

    private static Operator singleton = null;

    private Operator() {
        super();
    };

    public static synchronized Operator getInstance() {
        if (singleton == null) {
            singleton = new Operator();
        }
        return singleton;
    }

    int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
