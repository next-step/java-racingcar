package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumber {

    private final int number;

    private PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    static PositiveNumbers convertToPositiveNumbers(String[] splitText) {
        List<PositiveNumber> collect = Arrays.stream(splitText)
                .map(v -> new PositiveNumber(getInteger(v)))
                .collect(Collectors.toList());
        return new PositiveNumbers(collect);
    }

    private static int getInteger(String v) {
        return Integer.parseInt(v);
    }

    int getNumber() {
        return number;
    }
}
