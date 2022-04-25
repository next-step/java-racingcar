package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    private PositiveNumbers(String[] values) {
        List<PositiveNumber> positiveNumbers = new ArrayList<>(values.length);
        for (String value : values) {
            positiveNumbers.add(PositiveNumber.of(value));
        }
        this.positiveNumbers = positiveNumbers;
    }

    public static PositiveNumbers of(String[] values) {
        return new PositiveNumbers(values);
    }

    public int sum() {
        return this.getPositiveNumbers().stream().map(PositiveNumber::getNumber).reduce(0, Integer::sum);
    }

    public List<PositiveNumber> getPositiveNumbers() {
        return Collections.unmodifiableList(positiveNumbers);
    }
}
