package calculator.model;

import calculator.parser.TextSplitter;
import java.util.List;
import java.util.stream.Collectors;

public class NonNegativeNumbers {

    private final List<NonNegativeNumber> values;

    public NonNegativeNumbers(final List<NonNegativeNumber> values) {
        this.values = values;
    }

    public static NonNegativeNumbers of(final TextSplitter textSplitter) {
        return new NonNegativeNumbers(
                textSplitter.getValues()
                            .stream()
                            .map(NonNegativeNumber::of)
                            .collect(Collectors.toList())
        );
    }

    public int sum() {
        return this.values.stream()
                          .mapToInt(NonNegativeNumber::intValue)
                          .sum();
    }
}
