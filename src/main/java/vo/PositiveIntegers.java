package vo;

import java.util.List;

public class PositiveIntegers {
    private final List<Integer> values;

    private PositiveIntegers(List<Integer> values) {
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

    public static PositiveIntegers of(List<Integer> values) {
        return new PositiveIntegers(values);
    }

    public int sum() {
        return values.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
