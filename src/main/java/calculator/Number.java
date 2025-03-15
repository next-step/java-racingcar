package calculator;

import java.util.Arrays;

public class Number {
    public static int sum(int[] input){
        return Arrays.stream(input)
                .filter(Number::isPositive)
                .sum();
    }
    public static boolean isPositive(int number){
        if(number < 0) {
            throw new NegativeNumberException("invalid value");
        }
        return true;
    }
}
