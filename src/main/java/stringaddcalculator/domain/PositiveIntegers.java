package stringaddcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveIntegers {

    private final List<PositiveInteger> positiveInts;

    private PositiveIntegers(List<PositiveInteger> positiveIntegers) {
        this.positiveInts = positiveIntegers;
    }

    public static PositiveIntegers ofStringArray(final String[] strings) {
        List<PositiveInteger> positiveIntegerList = Arrays.stream(strings)
                .map(PositiveInteger::of)
                .collect(Collectors.toList());

        return new PositiveIntegers(positiveIntegerList);
    }

    public int sumAll() {
        return this.positiveInts.stream()
                .mapToInt(PositiveInteger::getNumber)
                .sum();
    }
}
