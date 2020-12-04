package calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    private static final String FORMULA_PATTERN = "[0-9]+(\\s[+\\-*/]\\s[0-9]+)+";
    private static final String DIV_ZERO_PATTERN = "/ 0";
    private static final String DELIMITER_SPACE = " ";
    private static final Pattern numberPattern = Pattern.compile("[0-9]+");

    private Map<String, BiFunction<Integer, Integer, Integer>> calculateFunctionMap;
    private List<Integer> numbers;
    private List<String> expressions;

    public StringCalculator(String values) {
        boolean validateResult = validate(values);
        if (!validateResult) {
            throw new IllegalArgumentException("잘못된 계산식입니다.");
        }

        initializeCalculateFunction();
        splitValues(values.split(DELIMITER_SPACE));
    }

    StringCalculator(List<Integer> numbers, List<String> expressions) {
        this.numbers = numbers;
        this.expressions = expressions;
    }

    private void initializeCalculateFunction() {
        calculateFunctionMap = new HashMap<>();
        calculateFunctionMap.put("+", (x, y) -> x + y);
        calculateFunctionMap.put("-", (x, y) -> x - y);
        calculateFunctionMap.put("*", (x, y) -> x * y);
        calculateFunctionMap.put("/", (x, y) -> x / y);
    }

    private void splitValues(String[] split) {
        numbers = Stream.of(split)
              .filter(value -> numberPattern.matcher(value).matches())
              .map(value -> Integer.parseInt(value))
              .collect(Collectors.toList());

        expressions = Stream.of(split)
              .filter(value -> !numberPattern.matcher(value).matches())
              .collect(Collectors.toList());
    }

    private boolean validate(String values) {
        if (StringUtils.isBlank(values)) {
            return false;
        }

        if (values.contains(DIV_ZERO_PATTERN)) {
            return false;
        }

        return Pattern.matches(FORMULA_PATTERN, values);
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

    public int calculate() {
        int result = numbers.get(0);

        for (int i = 0; i < expressions.size(); i++) {
            BiFunction<Integer, Integer, Integer> calcFunction = calculateFunctionMap
                  .get(expressions.get(i));

            result = calcFunction.apply(result, numbers.get(i + 1));
        }

        return result;
    }
}
