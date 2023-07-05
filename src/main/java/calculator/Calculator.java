package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static int sum(String text) {
        String[] strings = StringUtil.split(text);

        List<Integer> numbers = Arrays.stream(strings)
            .map(StringUtil::toInt)
            .collect(Collectors.toList());
        List<Positive> positiveNumbers = numbers.stream()
            .map(Positive::new)
            .collect(Collectors.toList());

        return positiveNumbers.stream()
            .map(o -> o.getNum())
            .reduce((i1, i2) -> i1 + i2).get();
    }
}
