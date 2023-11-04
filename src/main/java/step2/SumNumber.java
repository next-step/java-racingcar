package step2;

import java.util.Arrays;

public class SumNumber {

    public static int sum(int[] splitNumbers) {
        return Arrays.stream(splitNumbers).sum();
    }
}
