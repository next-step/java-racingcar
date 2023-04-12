package calculator;

import java.util.List;

public class Calculator {
    public Integer sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
