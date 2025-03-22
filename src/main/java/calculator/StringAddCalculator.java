package calculator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITERS = "[,:]";

    public static int splitAndSum(String str) {
        if(str == null) return 0;
        if(str.isEmpty()) return 0;

        return Arrays.stream(str.split(DEFAULT_DELIMITERS))
                .mapToInt( tokenString -> {
                    int number = Integer.parseInt(tokenString);
                    if(number < 0) throw new RuntimeException();

                    return number;
                })
                .sum();
    }

}
