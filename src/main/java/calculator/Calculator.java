package calculator;

public class Calculator {

    public int calculate(String input) {

        UserInput uInput = new UserInput(input);

        int result = uInput.getNumber();

        while (uInput.inputToCalculateIsRemaining()) {
            result = doCalculate(result, uInput.getOperator(), uInput.getNumber());
        }

        return result;
    }


    private int doCalculate(int input1, String operator, int input2) {
        switch (operator) {
           case "+":
               return add(input1, input2);
           case "-":
               return subtract(input1, input2);
           case "*":
               return multiply(input1, input2);
           case "/":
               return divide(input1, input2);
            default:
                return 0;
        }
    }

    public int add(int input1, int input2) {
        return input1 + input2;
    }

    public int subtract(int input1, int input2) {
        return input1 - input2;
    }

    public int divide(int input1, int input2) {
        return input1 / input2;
    }

    public int multiply(int input1, int input2) {
        return input1 * input2;
    }
}
