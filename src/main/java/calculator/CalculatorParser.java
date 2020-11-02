package calculator;

import calculator.domain.Operator;
import calculator.domain.factory.OperatorFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorParser {

    private static final String REGEX_BLANK = " ";

    public String[] parseExpression(String input) {
        checkInputArgument(input);
        return input.split(REGEX_BLANK);
    }

    private void checkInputArgument(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
        }
    }

    public int getInitialValue(String[] expression) {
        return Integer.parseInt(expression[0]);
    }

    public List<Operator> getOperatorList(String[] expression) {
        return Arrays.stream(expression)
                .filter(OperatorFactory::isOperator)
                .map(OperatorFactory::build)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumberListWithoutInitialNumber(String[] expression) {
        return Arrays.stream(expression)
                .filter(OperatorFactory::isNotOperator)
                .map(Integer::parseInt)
                .skip(1) // expression의 초기값은 제외
                .collect(Collectors.toList());
    }

    public void validate(List<Operator> operators, List<Integer> numbers) {
        if (operators.size() != numbers.size()) {
            throw new IllegalArgumentException("입력값의 수식이 잘못되었습니다.");
        }
    }

}
