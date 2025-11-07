package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record PositiveZeros(List<PositiveOrZero> values) {

    public PositiveZeros {
        validate(values);
        values = List.copyOf(values);
    }

    private static void validate(List<PositiveOrZero> inputs) {
        Objects.requireNonNull(inputs, "양수 목록은 null일 수 없습니다.");
        validateNotEmpty(inputs);
    }

    private static void validateNotEmpty(List<PositiveOrZero> inputs) {
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException("양수 목록은 비어있을 수 없습니다.");
        }
    }

    public static PositiveZeros from(String[] stringArray) {
        Objects.requireNonNull(stringArray, "문자열 배열은 null일 수 없습니다.");

        return new PositiveZeros(
                Arrays.stream(stringArray)
                        .map(PositiveOrZero::from)
                        .toList()
        );
    }

    public int sum() {
        return Arrays.stream(toIntArray()).sum();
    }

    private int[] toIntArray() {
        return values.stream()
                .mapToInt(PositiveOrZero::value)
                .toArray();
    }
}
