package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    private List<PositiveNumber> values;

    public PositiveNumbers(String[] strings) {
        values = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .mapToObj(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    public List<Integer> toIntegerList() {
        return values.stream()
                .map(PositiveNumber::intValue)
                .collect(Collectors.toList());
    }
}
