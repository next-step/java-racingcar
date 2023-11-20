package calculator;

import calculator.separator.Separator;
import java.util.List;

public class Calculator {

    public static final String CANNOT_CALCULATE_EXCEPTION = "계산할 수 없는 수식입니다. 현재 계산기에 해당 수식을 계산할 수 있는 구분자가 존재하지 않습니다.";
    private static final String DEFAULT_SUM_NUMBER = "0";
    private final List<Separator> separators;

    public Calculator(List<Separator> separators) {
        this.separators = separators;
    }

    public PositiveNumber calculate(String text) {
        if (isNothing(text)) {
            return calculateSumWithNothing();
        }

        return separators.stream().filter(separator -> separator.matchable(text)).findFirst()
                .map(separator -> calculateSum(separator.separate(text)))
                .orElseThrow(() -> new IllegalStateException(CANNOT_CALCULATE_EXCEPTION));
    }

    private boolean isNothing(String text) {
        return text == null || text.isBlank() || text.isEmpty();
    }

    private PositiveNumber calculateSumWithNothing() {
        return new PositiveNumber(DEFAULT_SUM_NUMBER);
    }

    private PositiveNumber calculateSum(List<String> separatedText) {
        PositiveNumber sum = new PositiveNumber(DEFAULT_SUM_NUMBER);
        for (String value : separatedText) {
            PositiveNumber number = new PositiveNumber(value);
            sum = sum.plus(number);
        }
        return sum;
    }
}
