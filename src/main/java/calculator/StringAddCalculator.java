package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String str) {
        if(str == null) return 0;
        if(str.isEmpty()) return 0;

        return Arrays.stream(StringTokenizer.tokenize(str))
                .mapToInt( tokenString -> {
                    int number = Integer.parseInt(tokenString);
                    if(number < 0) throw new RuntimeException("음의 정수는 계산할 수 없습니다.");

                    return number;
                })
                .sum();
    }

}
