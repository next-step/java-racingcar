package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public int splitAndSum(String input) {
        if(input == null || input.isBlank()) {
            return 0;
        }
        return sum(getIntegerList(input));
    }

    public int sum(List<Integer> list) {
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        return sum;
    }

    private static List<Integer> getIntegerList(String input) {
        List<Integer> list = Arrays.stream(split(input))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return list;
    }

    private static String[] split(String input) {
        if(input.length() >= 4 && input.charAt(0) == '/' && input.charAt(1) == '/'
        && input.charAt(3) == '\n') {
            String separator = String.valueOf(input.charAt(2));
            return input.substring(4).split(separator);
        }
        return input.split(",|:");
    }
}
