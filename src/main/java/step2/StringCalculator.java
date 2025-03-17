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
        CustomDelimiter delimiter = new CustomDelimiter();
        if (delimiter.hasCustomDelimiter(s)) {
            String[] numbers = delimiter.extractAndSplit(s);
            return Arrays.stream(numbers).map(Integer::parseInt).reduce(0, Integer::sum);
        }
        String[] numbers = s.split(",|:");
        return Arrays.stream(numbers).map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
