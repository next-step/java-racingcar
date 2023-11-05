package calculator.operator;

import java.util.List;

public class AddOperator implements Operator{
    @Override
    public int cal(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
