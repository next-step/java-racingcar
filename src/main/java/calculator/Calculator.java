package calculator;

import calculator.separator.Separator;
import java.util.List;

public class Calculator {

    private static final String ZERO = "0";
    public static final String CANNOT_CALCULATE_EXCEPTION = "계산할 수 없는 수식입니다.";
    private final List<Separator> separators;

    public Calculator(List<Separator> separators) {
        this.separators = separators;
    }

    public PositiveNumber calculate(String text) {

        if (isNothing(text)) {
            return calculateSumWithNothing();
        }
      
        for (Separator separator : separators) {
            if (separator.matchable(text)) {
                return calculateSum(separator.separate(text));
            }
        }

        throw new IllegalStateException(CANNOT_CALCULATE_EXCEPTION);
    }

    private boolean isNothing(String text) {
        return text == null || text.isBlank() || text.isEmpty();
    }

    private PositiveNumber calculateSumWithNothing() {
        return new PositiveNumber(ZERO);
    }

    private PositiveNumber calculateSum(List<String> separatedText) {
        PositiveNumber sum = new PositiveNumber(ZERO);
        for (String value : separatedText) {
            PositiveNumber number = new PositiveNumber(value);
            sum = sum.plus(number);
        }
        return sum;
    }
}
