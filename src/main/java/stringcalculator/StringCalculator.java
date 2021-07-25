package stringcalculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {

    private final Map<String, Operator> operations = new HashMap<>();

    {
        operations.put("+", new PlusOperator());
        operations.put("-", new MinusOperator());
        operations.put("*", new MultipleOperator());
        operations.put("/", new DivideOperator());
    }

    public int calculate(String input) {
        int result = 0;
        String[] spliced = removeSpaces(input);
        for (int i = 0; i < spliced.length - 1; i += 2) {
            result = operate(spliced[i], spliced[i + 1], spliced[i + 2]);
            spliced[i + 2] = Integer.toString(result);
        }
        return result;
    }

    private int operate(String operand, String operator, String anotherOperand) {
        if (!operations.containsKey(operator)) {
            throw new IllegalArgumentException();
        }
        return operations.get(operator).calculate(Integer.parseInt(operand), Integer.parseInt(anotherOperand));
    }

    private String[] removeSpaces(String input) {
        if (input == null || input.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        return input.split(" ");
    }
}
