package calculator;

public class Calculator {

    public int calculate(String input) {

        UserInput uInput = new UserInput(input);
        int result = uInput.getNumber();

        while (uInput.inputToCalculateIsRemaining()) {
            result = calculateUsingOneOperator(result, uInput.getOperator(), uInput.getNumber());
        }
        return result;
    }


    private int calculateUsingOneOperator(int input1, String operator, int input2) {
        return Operator.of(operator).calculate(input1, input2);
    }

}
