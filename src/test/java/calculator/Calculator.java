package calculator;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator {

    Stack<String> stack = new Stack();

    public Long calculate(String input) {
        if (input == null || input.trim().length() == 0) {
            throw new IllegalArgumentException("empty string");
        }

        List<String> supportedOperator = Arrays.asList("+", "-", "*", "/");
        input = input.trim();
        String[] elements = input.split(" ");
        for (String element : elements) {
            if (isNumber(element)) {
                continue;
            }

            if (!supportedOperator.contains(element)) {
                throw new IllegalArgumentException("not supported operator");
            }
        }

        for (String element : elements) {

            if(!stack.isEmpty() && supportedOperator.contains(stack.peek())){
                //연산
                String operator = stack.pop();
                String operand = stack.pop();

                if(operator.equals("+")){
                    long result = (Long.parseLong(operand) + Long.parseLong(element));
                    stack.push(String.valueOf(result));
                }

                if(operator.equals("-")){
                    long result = (Long.parseLong(operand) - Long.parseLong(element));
                    stack.push(String.valueOf(result));
                }

                if(operator.equals("*")){
                    long result = (Long.parseLong(operand) * Long.parseLong(element));
                    stack.push(String.valueOf(result));
                }

                if(operator.equals("/")){
                    long result = (Long.parseLong(operand) / Long.parseLong(element));
                    stack.push(String.valueOf(result));
                }

                continue;
            }
            stack.push(element);
        }

        return Long.parseLong(stack.pop());
    }

    private boolean isNumber(String element) {
        try {
            Long.parseLong(element);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
