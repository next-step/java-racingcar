package vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.NumberUtils;

public class SplitStrings {

    private final List<String> values;

    private SplitStrings(String[] values) {
        this.values = Arrays.asList(values);
    }

    public static SplitStrings of(String[] values) {
        return new SplitStrings(values);
    }

    public PositiveIntegers toIntegers() {
        return PositiveIntegers.of(
            values.stream()
                .map(s -> {
                    validateNotNumber(s);
                    return Integer.parseInt(s);
                })
                .collect(Collectors.toList()));
    }

    private static void validateNotNumber(String s) {
        if (!NumberUtils.isNumber(s)) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
