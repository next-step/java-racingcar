package stringcalculator;

import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public int sum() {
        return positiveNumbers.stream()
                .map(PositiveNumber::getNumber)
                .reduce(0, Integer::sum);
    }
}
