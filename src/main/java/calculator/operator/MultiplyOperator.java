package calculator.operator;

import java.util.List;

public class MultiplyOperator implements Operator{
    @Override
    public int cal(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .reduce((x,y) -> x * y)
                .getAsInt();
    }
}
