package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record PositiveOrZeros(List<PositiveOrZero> values) {

    public PositiveOrZeros {
        Objects.requireNonNull(values, "값 목록은 null일 수 없습니다.");
        values = List.copyOf(values);
    }

    public PositiveOrZeros(String[] inputs) {
        this(toValidatedList(inputs));
    }

    private static List<PositiveOrZero> toValidatedList(String[] inputs) {
        Objects.requireNonNull(inputs, "문자열 배열은 null일 수 없습니다.");
        return Arrays.stream(inputs)
                .map(PositiveOrZero::new)
                .toList();
    }

    public int sum() {
        return values.stream()
                .mapToInt(PositiveOrZero::value)
                .sum();
    }
}
