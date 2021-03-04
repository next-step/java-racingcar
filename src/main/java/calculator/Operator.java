package calculator;

public interface Operator {
    static boolean isOperator(String value) {
        try {
            parseOperator(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    static Operator parseOperator(String value) {
        if (value.equals("+")) return new Addition();
        if (value.equals("-")) return new Subtraction();
        if (value.equals("*")) return new Multiplication();
        if (value.equals("/")) return new Division();
        throw new IllegalArgumentException();
    }

    int calculate(int operand1, int operand2);
}
