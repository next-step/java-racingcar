package step2;

import java.util.Collections;
import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    private PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public static PositiveNumbers of(List<PositiveNumber> numbers) {
        return new PositiveNumbers(numbers);
    }

    public int sum() {
        int sum = 0;
        for (PositiveNumber number : this.getPositiveNumbers()) {
            sum += number.getNumber();
        }
        return sum;
    }

    public List<PositiveNumber> getPositiveNumbers() {
        return Collections.unmodifiableList(positiveNumbers);
    }
}
