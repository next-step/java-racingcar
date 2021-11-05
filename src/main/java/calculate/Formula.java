package calculate;

import java.util.Stack;

public class Formula {
    private final Stack<Integer> numberStack = new Stack<>();
    private final Stack<String> operatorStack = new Stack<>();

    public Formula(String rawFormula) {
        String[] tokens = rawFormula.split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                numberStack.push(Integer.parseInt(tokens[i]));
            }
            if (i % 2 == 1) {
                operatorStack.push(tokens[i]);
            }
        }
    }

    public int calculate() {
        Stack<Integer> numberStack = (Stack<Integer>) this.numberStack.clone();
        Stack<String> operatorStack = (Stack<String>) this.operatorStack.clone();

        while (!operatorStack.empty()) {
            numberStack.push(
                    calculate(numberStack.pop(), operatorStack.pop(), numberStack.pop())
            );
        }
        return numberStack.pop();
    }

    private int calculate(int n1, String operator, int n2) {
        if (operator.equals("+")) {
            return n1 + n2;
        }

        if (operator.equals("-")) {
            return n1 - n2;
        }

        if (operator.equals("*")) {
            return n1 * n2;
        }

        if (operator.equals("/")) {
            if (n2 == 0) {
                throw new IllegalArgumentException("분모 0");
            }
            return n1 / n2;
        }

        throw new IllegalArgumentException("사칙연산만 가능합니다");
    }
}
