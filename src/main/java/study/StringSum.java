package study;

import java.util.Arrays;

public class StringSum {


    public int sumStringByDelimiter(String data) {
        String[] split = data.split(",|:");

        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
