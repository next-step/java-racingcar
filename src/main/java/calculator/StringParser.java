package calculator;

import java.util.Arrays;

public class StringParser {

    public static int[] toInt(String [] input){
        return Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
