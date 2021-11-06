package level2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factor {
    List<Number> numbers;
    List<Operator> operators;
    List<String> test;

    public Factor(String input) {
        String[] inputs = input.split(" ");

        test = Arrays.stream(inputs)
                    .filter(i -> i.matches("-?\\d+?"))
                    .collect(Collectors.toList());

        numbers = Arrays.stream(inputs)
                        .filter(i -> i.chars().allMatch(Character::isDigit))
                        .map(i ->new Number((String)i))
                        .collect(Collectors.toList());
        //operator 도 동일하게 넣는다
        Number number1 = new Number(inputs[0]);
        Number number2 = new Number(inputs[2]);

        Operator operator = Arrays.stream(Operator.values())
                .filter(o ->o.isEqualTo(inputs[1]))
                .findAny().orElseThrow(() -> new IllegalArgumentException());
    }

}
