package woowacamp.calculator;

import java.util.List;

public class Calculator {
    public static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
