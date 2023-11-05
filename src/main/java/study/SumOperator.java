package study;

import java.util.List;

public class SumOperator {
    public int sum(List<String> numbers) {
        return numbers.stream()
                .map(PositiveNumber::new)
                .mapToInt(PositiveNumber::value)
                .sum();
    }
}
