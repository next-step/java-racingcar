package stringCalculator;


import java.util.HashSet;
import java.util.Set;

public class Operator {

    private Set<String> validOperators;

    public Operator() {
        validOperators = new HashSet<>();

        validOperators.add("+");
        validOperators.add("-");
        validOperators.add("*");
        validOperators.add("/");
    }

    boolean isValidOperator(String operator) {
        return validOperators.contains(operator);
    }

    int calculateWithOperator(int result, String operator, int operand) {
        if (operator.equals("+"))
            return result + operand;

        if (operator.equals("-"))
            return result - operand;

        if (operator.equals("*"))
            return result * operand;

        if (operator.equals("/"))
            return result / operand;

        throw new IllegalArgumentException();
    }

}
