package stringcalculator;

import stringcalculator.arithmeticcomponent.ArithmeticExpression;
import stringcalculator.arithmeticcomponent.ArithmeticOperand;
import stringcalculator.arithmeticcomponent.ArithmeticOperator;
import stringcalculator.arithmeticcomponent.ArithmeticResult;
import stringcalculator.console.InputExpression;
import util.NotationUtils;

import java.util.Stack;

/**
 * 중위 표기법식 문자열 수식을 계산하는 계산기
 * 구분자는 " "(공백)으로 정의
 * 계산 순서는 좌 => 우
 */
public class StringCalculator {

    private static final String DELIMITER = " ";

    public static ArithmeticResult calculate(InputExpression inputExpression) {
        return calculateInfixExpression(inputExpression.getExpression());
    }

    private static ArithmeticResult calculateInfixExpression(String infixExpression) {
        String[] infixValues = infixExpression.split(DELIMITER);
        Stack<String> postfixStack = NotationUtils.convertPostfixStack(infixValues);
        while (true) {
            if (postfixStack.size() == 1) {
                int result = Integer.parseInt(postfixStack.pop());
                return new ArithmeticResult(result);
            }
            ArithmeticOperand num1 = new ArithmeticOperand(Integer.parseInt(postfixStack.pop()));
            ArithmeticOperand num2 = new ArithmeticOperand(Integer.parseInt(postfixStack.pop()));
            ArithmeticOperator operator = ArithmeticOperator.findByOperator(postfixStack.pop());
            ArithmeticExpression arithmeticExpression = new ArithmeticExpression(num1, operator, num2);
            String result = String.valueOf(arithmeticExpression.result());
            postfixStack.push(result);
        }
    }
}
