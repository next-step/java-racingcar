package calculator;

import calculator.domain.Operator;
import calculator.domain.factory.OperatorFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorParser {

    private static final String REGEX_BLANK = " ";
    private static final int ZERO = 0;
    private static final int INITIAL_ELEMENT_NUMBER = 1;

    private static final String ERROR_MESSAGE_INPUT_NULL_OR_BLANK = "입력값이 null이거나 빈 공백 문자입니다.";
    private static final String ERROR_MESSAGE_INPUT_WRONG = "입력값의 수식이 잘못되었습니다.";
    private static final String ERROR_MESSAGE_UTILITY_CLASS = "유틸성 클래스입니다.";

    private CalculatorParser() {
        throw new IllegalStateException(ERROR_MESSAGE_UTILITY_CLASS);
    }

    public static String[] parseExpression(String input) {
        checkInputArgument(input);
        return input.split(REGEX_BLANK);
    }

    private static void checkInputArgument(String input) {
        if (input == null || input.length() == ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_NULL_OR_BLANK);
        }
    }

    public static int getInitialValue(String[] expression) {
        return Integer.parseInt(expression[ZERO]);
    }

    public static List<Operator> getOperatorList(String[] expression) {
        return Arrays.stream(expression)
                .filter(OperatorFactory::isOperator)
                .map(OperatorFactory::build)
                .collect(Collectors.toList());
    }

    public static List<Integer> getNumberListWithoutInitialNumber(String[] expression) {
        return Arrays.stream(expression)
                .filter(OperatorFactory::isNotOperator)
                .map(Integer::parseInt)
                .skip(INITIAL_ELEMENT_NUMBER) // expression의 초기값은 제외
                .collect(Collectors.toList());
    }

    public static void validate(List<Operator> operators, List<Integer> numbers) {
        if (operators.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_WRONG);
        }
    }

}
