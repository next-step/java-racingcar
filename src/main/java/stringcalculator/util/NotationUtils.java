package stringcalculator.util;

import stringcalculator.arithmeticcomponent.ArithmeticOperator;

import java.util.Stack;

/**
 * 표기법 관련 Util
 */
public class NotationUtils {
    public static StringBuilder convertInfixIntoPostfix(String[] infixValues) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (String value : infixValues) {
            if (ArithmeticOperator.isContained(value)) {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                stack.push(value);
                continue;
            }
            result.append(value);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result;
    }

    public static Stack<String> convertPostfixStack(String[] infixValues) {
        StringBuilder postfixExpression = NotationUtils.convertInfixIntoPostfix(infixValues);
        String reversePostfixExpression = postfixExpression.reverse().toString();
        return convertStack(reversePostfixExpression);
    }

    private static Stack<String> convertStack(String expression) {
        Stack<String> stack = new Stack<>();
        for (char value : expression.toCharArray()) {
            stack.push(String.valueOf(value));
        }
        return stack;
    }
}
