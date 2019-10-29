package step1;

import java.util.Stack;

public class StringCalculator2 {

    private final static String SEPARATOR = " ";
    private final static String[] OPERATORS = {"+", "-", "*", "/"};
    private String[] requests;
    private Stack<Integer> numberStack = new Stack<>();
    private Stack<String> operatorStack = new Stack<>();
    private int result = 0;
    private String currentOperator = null;

    public int execute(String input) {
        inputValidate(input);

        requests = input.split(SEPARATOR);
        for (int i = requests.length - 1; i >= 0; i--) {
            separate(i);
        }
        return calculate();
    }

    public void inputValidate(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void operatorValidate(String operator) {
        for (int i = 0; i < OPERATORS.length; i++) {
            if (!OPERATORS[i].contains(operator)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int calculate() {
        result = numberStack.pop();
        for (; !operatorStack.empty(); ) {
            currentOperator = operatorStack.pop();
            operatorValidate(currentOperator);
            addOperatorCheck();
            subtractOperatorCheck();
            multiplyOperatorCheck();
            divideOperatorCheck();
        }
        return result;
    }

    private void addOperatorCheck() {
        if (currentOperator.equals("+")) {
            result = add(result, numberStack.pop());
        }
    }

    private void subtractOperatorCheck() {
        if (currentOperator.equals("-")) {
            result = subtract(result, numberStack.pop());
        }
    }

    private void multiplyOperatorCheck() {
        if (currentOperator.equals("*")) {
            result = multiply(result, numberStack.pop());
        }
    }

    private void divideOperatorCheck() {
        if (currentOperator.equals("/")) {
            result = divide(result, numberStack.pop());
        }
    }


    public int add(int result, int num) {
        return result + num;
    }

    public int subtract(int result, int num) {
        return result - num;
    }

    public int multiply(int result, int num) {
        return result * num;
    }

    public int divide(int result, int num) {
        return result / num;
    }

    private void separate(int i) {
        try {
            numberSeparate(i);
        } catch (Exception e) {
            operatorSeparate(i);
        }
    }

    private void numberSeparate(int i) {
        numberStack.push(Integer.parseInt(requests[i]));
    }

    private void operatorSeparate(int i) {
        operatorStack.push(requests[i]);
    }

}
