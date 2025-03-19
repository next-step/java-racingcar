package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public PositiveNumbers(String[] numbers) {
        this.positiveNumbers = Arrays.stream(numbers)
            .map(PositiveNumber::new)
            .collect(Collectors.toList());
    }

    public int sum() {
        return positiveNumbers.stream()
            .reduce(new PositiveNumber(0), PositiveNumber::sum)
            .getValue();
    }
}
