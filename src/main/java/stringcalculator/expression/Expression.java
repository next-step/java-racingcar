package stringcalculator.expression;

import stringcalculator.calculator.Calculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Expression {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("^(\\+)|(-)|(\\*)|(/)$");

    private static final int FIRST_INDEX = 0;
    private static final String DELIMITER = " ";

    private String[] expressions;

    private List<String> numbers;
    private List<String> operators;

    public Expression(String source) {
        if (isEmpty(source)) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }
        this.expressions = source.split(DELIMITER);
        if (isNotValidOperator()) {
            throw new IllegalArgumentException("입력 값은 숫자로만 시작해야 합니다.");
        }
        numbers = collectNumber();
        operators = collectOperator();
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getOperators() {
        return operators;
    }

    private List<String> collectOperator() {
        List<String> collect = Stream.of(expressions).filter(this::getOperator).collect(Collectors.toList());
        if (Math.floor(expressions.length / 2) != collect.size()) {
            throw new IllegalArgumentException("연산자는 사칙연산 기호만 사용할 수 있습니다.");
        }
        return collect;
    }

    private List<String> collectNumber() {
        if (!INTEGER_PATTERN.matcher(expressions[FIRST_INDEX]).find()) {
            throw new IllegalArgumentException("입력값은 반드시 숫자로 시작해야 한다");
        }
        return Stream.of(expressions).filter(this::getNumber).collect(Collectors.toList());
    }

    public Double calculate() {
        double leftNumber = Double.parseDouble(numbers.get(0));
        for (int i = 1; i < operators.size() + 1; i++) {
            String operator = operators.get(i - 1);
            String rightNumber = numbers.get(i);
            leftNumber = Calculator.calculate(operator, leftNumber, Double.parseDouble(rightNumber));
        }
        return leftNumber;
    }

    private boolean getNumber(String expression) {
        return INTEGER_PATTERN.matcher(expression).find();
    }

    private boolean getOperator(String expression) {
        return OPERATOR_PATTERN.matcher(expression).find();
    }

    private boolean isEmpty(String source) {
        return source == null || "".equals(source.trim());
    }

    private boolean isNotValidOperator() {
        return !INTEGER_PATTERN.matcher(expressions[FIRST_INDEX]).find();
    }

}
