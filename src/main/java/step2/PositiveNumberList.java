package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumberList {
    private List<PositiveNumber> list;

    public PositiveNumberList(String[] strings) {
        list = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .mapToObj(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    public List<Integer> toIntegerList() {
        return list.stream()
                .map(PositiveNumber::intValue)
                .collect(Collectors.toList());
    }
}
