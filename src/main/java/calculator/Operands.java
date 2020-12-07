package calculator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {

    private final List<Integer> numbers;

    public Operands(List<String> strNumbers) {
        this.numbers = Collections.unmodifiableList(map(strNumbers));
    }

    private static List<Integer> map(List<String> strNumbers) {
        return strNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int size() {
        return numbers.size();
    }

    public Integer get(int index) {
        return numbers.get(index);
    }
}
