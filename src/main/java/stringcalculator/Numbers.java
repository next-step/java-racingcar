package stringcalculator;

import java.util.List;

public class Numbers {

    private final List<PositiveNumber> positiveNumbers;

    public Numbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public int sum() {
        return positiveNumbers.stream()
                .map(PositiveNumber::getNumber)
                .reduce(0, Integer::sum);
    }
}
