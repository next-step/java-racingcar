package step1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringCalculator2 {

    private final static String SEPARATOR = " ";
    private int result = 0;
    private String[] requests;
    private String currentOperator = null;
    private Stack<Integer> numberStack = new Stack<>();
    private Stack<String> operatorStack = new Stack<>();
    private Map<String, CalculatorType> operatorMap;

    public StringCalculator2() {
        operatorInit();
    }

    private void operatorInit() {
        operatorMap = new HashMap<>();
        operatorMap.put("+", CalculatorType.ADD);
        operatorMap.put("-", CalculatorType.SUBTRACT);
        operatorMap.put("*", CalculatorType.MULTIPLY);
        operatorMap.put("/", CalculatorType.DIVIDE);
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
        if (!operatorMap.containsKey(operator)) {
            throw new IllegalArgumentException();
        }
    }

    private int calculate() {
        result = numberStack.pop();
        for (; !operatorStack.empty(); ) {
            currentOperator = operatorStack.pop();
            operatorValidate(currentOperator);
            CalculatorType calculatorType = operatorMap.get(currentOperator);
            result = calculatorType.calculate(result, numberStack.pop());
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
