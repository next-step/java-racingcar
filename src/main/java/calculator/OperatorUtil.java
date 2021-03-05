package calculator;

class OperatorUtil {
    static boolean isOperator(String value) {
        try {
            parseOperator(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    static Operator parseOperator(String value) {
        if (value.equals("+")) return Operator.ADDITION;
        if (value.equals("-")) return Operator.SUBTRACTION;
        if (value.equals("*")) return Operator.MULTIPLICATION;
        if (value.equals("/")) return Operator.DIVISION;
        throw new IllegalArgumentException();
    }
}
