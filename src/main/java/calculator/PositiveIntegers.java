package calculator;

import java.util.List;

public final class PositiveIntegers {
    private final List<PositiveInteger> positiveIntegers;

    public PositiveIntegers(List<PositiveInteger> positiveIntegers) {
        this.positiveIntegers = positiveIntegers;
    }

    public int sum() {
        return positiveIntegers.stream()
                .mapToInt(PositiveInteger::getNumber)
                .sum();
    }
}
