package step1;

import java.util.Stack;

public class StringCalculator2 {

    private final static String SEPARATOR = " ";
    private int result = 0;
    private String[] requests;
    private String currentOperator = null;
    private Stack<Integer> numberStack = new Stack<>();
    private Stack<String> operatorStack = new Stack<>();

    public StringCalculator2() {

    }

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
        if (!Operator.operator.containsKey(operator)) {
            throw new IllegalArgumentException();
        }
    }

    private int calculate() {
        result = numberStack.pop();
        for (; !operatorStack.empty(); ) {
            currentOperator = operatorStack.pop();
            operatorValidate(currentOperator);
            Operator operator = Operator.operator.get(currentOperator);
            result = operator.calculate(result, numberStack.pop());
        }
        return result;
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
