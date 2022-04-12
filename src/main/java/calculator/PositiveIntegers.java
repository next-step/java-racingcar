package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class PositiveIntegers {
    private final List<PositiveInteger> positiveIntegers;

    public PositiveIntegers(List<PositiveInteger> inputs) {
        validate(inputs);
        List<PositiveInteger> positiveIntegers = new ArrayList<>(inputs);
        this.positiveIntegers = positiveIntegers;
    }

    public void validate(List<PositiveInteger> positiveIntegers) {
        Objects.requireNonNull(positiveIntegers, "전달된 리스트가 올바르지 않습니다 : List is null");

        if (positiveIntegers.isEmpty()) {
            throw new IllegalArgumentException("전달된 리스트가 올바르지 않습니다 : List size is 0");
        }
    }

    public int sum() {
        return positiveIntegers.stream()
                .mapToInt(PositiveInteger::number)
                .sum();
    }
}
