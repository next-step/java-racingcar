package calculator.model;

import java.util.List;
import java.util.stream.Collectors;

public final class NonNegativeNumbers {

    private final List<NonNegativeNumber> values;

    private NonNegativeNumbers(final List<NonNegativeNumber> values) {
        this.values = values;
    }

    public static NonNegativeNumbers of(final List<String> values) {
        final List<NonNegativeNumber> nums = values.stream()
                                                   .map(NonNegativeNumber::of)
                                                   .collect(Collectors.toList());
        return new NonNegativeNumbers(nums);
    }

    public int sum() {
        return this.values.stream()
                          .mapToInt(NonNegativeNumber::intValue)
                          .sum();
    }
}
