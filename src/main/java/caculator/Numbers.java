package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record Numbers(List<Integer> values) {
    public Numbers {
        validate(values);
        values = List.copyOf(values);
    }

    private static void validate(List<Integer> inputs) {
        Objects.requireNonNull(inputs, "숫자 목록은 null일 수 없습니다.");
        validateNotEmpty(inputs);
    }
    private static void validateNotEmpty(List<Integer> inputs) {
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException("숫자 목록은 비어있을 수 없습니다.");
        }
    }

    public static Numbers from(int[] values) {
        Objects.requireNonNull(values, "숫자 배열은 null일 수 없습니다.");

        return new Numbers(
                Arrays.stream(values)
                        .boxed()
                        .toList());
    }

    public int sum() {
        return values.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
