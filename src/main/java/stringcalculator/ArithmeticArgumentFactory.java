package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ArithmeticArgumentFactory {

    private ArithmeticArgumentFactory() {
    }

    public static ArithmeticArguments createArgs(String expression) {
        if (!isArithmeticExpression(expression)) {
            throw new IllegalArgumentException("잘못된 수식을 입력하셨습니다.");
        }

        String[] elements = expression.split(" ");

        List<Integer> operands = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        for (String element : elements) {
            addArguments(element, operands, operators);
        }

        return new ArithmeticArguments(operands, operators);
    }

    private static void addArguments(String element, List<Integer> operands, List<Operator> operators) {
        if (Pattern.matches(ArithmeticPattern.OPERATOR.getPattern(), element)) {
            operators.add(Operator.getOperator(element));
            return;
        }
        if (Pattern.matches(ArithmeticPattern.OPERAND.getPattern(), element)) {
            operands.add(Integer.parseInt(element));
        }
    }

    private static boolean isArithmeticExpression(String expression) {
        return Pattern.matches(ArithmeticPattern.EXPRESSION.getPattern(), expression);
    }
}
