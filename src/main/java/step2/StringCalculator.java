package step2;

import java.util.Arrays;

public class StringCalculator {


    public static int splitAndSum(String s) {
        if (s == null) {
            return 0;
        }
        if (s.isEmpty()) {
            return 0;
        }
        String[] numbers = s.split(",|:");
        Integer result = Arrays.stream(numbers).map(Integer::parseInt).reduce(0, Integer::sum);
        return result;
    }
}
