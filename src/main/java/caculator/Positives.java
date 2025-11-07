package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record Positives(List<Positive> values) {

    public Positives {
        validate(values);
        values = List.copyOf(values);
    }

    private static void validate(List<Positive> inputs) {
        Objects.requireNonNull(inputs, "토큰 목록은 null일 수 없습니다.");
        validateNotEmpty(inputs);
    }

    private static void validateNotEmpty(List<Positive> inputs) {
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException("토큰 목록은 비어있을 수 없습니다.");
        }
    }

    public static Positives from(String[] tokens) {
        Objects.requireNonNull(tokens, "토큰 배열은 null일 수 없습니다.");

        return new Positives(
                Arrays.stream(tokens)
                        .map(Positive::from)
                        .toList()
        );
    }

    public int[] toIntArray() {
        return values.stream()
                .mapToInt(Positive::value)
                .toArray();
    }
}
