package step_2;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberConverter {

    public Function<List<String>, List<Integer>> toInts() {
        return values -> values.stream().map(this::toIntAndCheckNegativeNumber).collect(Collectors.toList());
    }

    private int toIntAndCheckNegativeNumber(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }

        return number;
    }
}
