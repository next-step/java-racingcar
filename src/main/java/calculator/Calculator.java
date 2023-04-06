package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public int sum(List<Integer> list) {
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        return sum;
    }

    public int splitAndSum(String input) {
        if(input == null || input.isBlank()) {
            return 0;
        }
        List<Integer> list = Arrays.stream(input.split(",|:"))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        return sum(list);
    }
}
