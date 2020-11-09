package step2.string.calculator;


public class StringCalculator {

    public int calculate(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException(Constants.INPUT_IS_NULL_OR_BLANK);
        }
        String [] expression = input.split(" ");
        int firstOperand = Integer.parseInt(expression[0]);

        for (int i=1; i < expression.length; i = i+2) {
            firstOperand = calculate(firstOperand, Integer.parseInt(expression[i+1]), expression[i]);
        }

        return firstOperand;
    }

    private boolean isNullOrBlank(String input){
        return input == null || input.trim().isEmpty();
    }

    private int calculate(int firstOperand, int secondOperand, String operator) {
        Operator op = Operator.fromString(operator);
        return op.apply(firstOperand, secondOperand);
    }
}
