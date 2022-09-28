package calculator;

import java.util.stream.Stream;

public class StringCalculator {
    private final PositiveNumberConverter numberConverter;

    public StringCalculator() {
        numberConverter = new PositiveNumberConverter();
    }

    public Integer sum(String originalSource) {
        if (isNullOrEmpty(originalSource)) {
            return 0;
        }

        CalculateInfo info = new CalculateInfo(originalSource);
        String[] numberStrings = info.numberStrings();

        return Stream.of(numberStrings)
                .mapToInt(numberConverter::toPositive)
                .sum();
    }

    private boolean isNullOrEmpty(String source) {
        return source == null || source.isEmpty();
    }
}
