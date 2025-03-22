package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String str) {
        if(str == null) return 0;
        if(str.isEmpty()) return 0;

        return Arrays.stream(StringTokenizer.tokenize(str))
                .mapToInt( tokenString -> {
                    int number = Integer.parseInt(tokenString);
                    if(number < 0) throw new RuntimeException();

                    return number;
                })
                .sum();
    }

}
