package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
    private static final String FORMULA_PATTERN = "[0-9]+(\\s[+\\-*/]\\s[0-9]+)+";
    private static final String DELIMITER_SPACE = " ";
    private static final Pattern numberPattern = Pattern.compile("[0-9]+");

    private List<Integer> numbers;
    private List<String> expressions;
    private CalculateFunction calculateFunction;

    public StringCalculator(String values) {
        boolean validateResult = validate(values);
        if (!validateResult) {
            throw new IllegalArgumentException("잘못된 계산식입니다.");
        }

        calculateFunction = new CalculateFunction();
        splitValues(values.split(DELIMITER_SPACE));
    }

    StringCalculator(List<Integer> numbers, List<String> expressions) {
        this.numbers = numbers;
        this.expressions = expressions;
    }

    public int calculate() {
        int result = numbers.get(0);

        for (int i = 0; i < expressions.size(); i++) {
            result = calculateFunction.calculate(expressions.get(i), result, numbers.get(i + 1));
        }

        return result;
    }

    private boolean validate(String values) {
        if (StringUtils.isBlank(values)) {
            return false;
        }

        return Pattern.matches(FORMULA_PATTERN, values);
    }

    private void splitValues(String[] split) {
        numbers = Stream.of(split)
                .filter(value -> numberPattern.matcher(value).matches())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        expressions = Stream.of(split)
                .filter(value -> !numberPattern.matcher(value).matches())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StringCalculator that = (StringCalculator) o;
        return Objects.equals(numbers, that.numbers) &&
                Objects.equals(expressions, that.expressions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, expressions);
    }
}
