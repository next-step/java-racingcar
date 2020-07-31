package stringcalculator;

public class StringCarculator {

    public int getStringCalculator(String operator, int firstNumber, int secondNumber) {
        if (operator.equals(CommonConstant.PLUS_SIGN)) {
            return Operator.PLUS.getSolve(firstNumber, secondNumber);
        }
        if (operator.equals(CommonConstant.MINUS_SIGN)) {
            return Operator.MINUS.getSolve(firstNumber, secondNumber);
        }
        if (operator.equals(CommonConstant.MULTIPLICATION_SIGN)) {
            return Operator.MULTIPLY_BY.getSolve(firstNumber, secondNumber);
        }
        if (operator.equals(CommonConstant.DIVISION_SIGN)) {
            return Operator.DIVIDED_BY.getSolve(firstNumber, secondNumber);
        }
        throw new IllegalArgumentException(operator + CommonConstant.IS_VALID_OPERATOR);
    }

}
