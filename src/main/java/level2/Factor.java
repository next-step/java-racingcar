package level2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factor {
    private List<Number> numbers;
    private List<Operator> operators;

    public Factor(String input) {
        if(input == null || input.isBlank()) throw new IllegalArgumentException();

        String[] inputs = input.split(" ");

        numbers = Arrays.stream(inputs)
                        .filter(i -> i.matches("-?\\d+?"))
                        .map(i -> new Number(i))
                        .collect(Collectors.toList());

        operators = Arrays.stream(inputs)
                          .flatMap(i -> Arrays.stream(Operator.values()).filter(o -> o.isEqualTo(i)))
                          .collect(Collectors.toList());
    }

    public Number getNumbers(int index) {
        return numbers.get(index);
    }

    public Operator getOperator(int index) {
        return operators.get(index);
    }

    public boolean isComplete(int expect) {
        return expect == numbers.size() + operators.size();
    }
}
