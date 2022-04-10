package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    static PositiveNumbers convertToPositiveNumbers(String[] splitText) {
        List<PositiveNumber> positiveNumbers = Arrays.stream(splitText)
                .map(PositiveNumber::createPositiveNumber)
                .collect(Collectors.toList());
        return new PositiveNumbers(positiveNumbers);
    }

    public int sum() {
        return positiveNumbers.stream()
                .map(PositiveNumber::getNumber)
                .reduce(0, Integer::sum);
    }
}
