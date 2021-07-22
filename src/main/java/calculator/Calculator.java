package calculator;

public class Calculator {

    public int calculate(String input) {
        String[] inputs = input.split(" ");
        String operator = inputs[1];
        if (operator.equals("+")) {
            return add(input);
        } else if(operator.equals("-")) {
            return subtract(input);
        } else if(operator.equals("*")) {
            return multiply(input);
        } return devide(input);
    }

    private int add(String input) {
        String[] inputs = input.split(" ");
        return toInt(inputs[0]) + toInt(inputs[2]);
    }

    private int subtract(String input) {
        String[] inputs = input.split(" ");
        return toInt(inputs[0]) - toInt(inputs[2]);
    }

    private int multiply(String input) {
        String[] inputs = input.split(" ");
        return toInt(inputs[0]) * toInt(inputs[2]);
    }

    private int devide(String input) {
        String[] inputs = input.split(" ");
        return toInt(inputs[0]) / toInt(inputs[2]);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
