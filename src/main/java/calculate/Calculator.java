package calculate;

import java.util.Arrays;
import java.util.Stack;

public class Calculator {

    public int calculate(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        String[] tokens = s.split(" ");

        for (int i = tokens.length - 1; i >= 0 ; i--) {
            if (i % 2 == 0) {
                numberStack.push(Integer.parseInt(tokens[i]));
            }
            if (i % 2 == 1) {
                operatorStack.push(tokens[i]);
            }
        }

        while (!operatorStack.empty()) {
            int result = calculate(numberStack.pop(), operatorStack.pop(), numberStack.pop());
            numberStack.push(result);
        }

        return numberStack.pop();
    }

    private int calculate(int n1, String operator, int n2) {
        if(operator.equals("+")) {
            return n1 + n2;
        }

        if(operator.equals("-")) {
            return n1 - n2;
        }

        if(operator.equals("*")) {
            return n1 * n2;
        }

        if(operator.equals("/")) {
            if(n2 == 0) {
                throw new IllegalArgumentException("분모 0");
            }
            return n1 / n2;
        }

        throw new IllegalArgumentException("사칙연산만 가능합니다");
    }
}
