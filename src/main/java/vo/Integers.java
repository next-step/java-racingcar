package vo;

import java.util.List;

public class Integers {
    private final List<Integer> values;

    private Integers(List<Integer> values) {
        validateNegative(values);
        this.values = values;
    }

    private static void validateNegative(List<Integer> values) {
        values.forEach(
            value -> {
                if (value < 0) {
                    throw new RuntimeException("음수는 더할 수 없습니다.");
                }
            }
        );
    }

    public static Integers of(List<Integer> values) {
        return new Integers(values);
    }

    public int sum() {
        return values.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
