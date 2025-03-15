package calculator;

import java.util.Arrays;

public class Numbers {
    private final PositiveNumber[] numbers;

    public Numbers(int[] number) {
        this.numbers = Arrays.stream(number)
                .mapToObj(PositiveNumber::new)
                .toArray(PositiveNumber[]::new);
    }

    public int sum() {
        return Arrays.stream(numbers)
                .mapToInt(PositiveNumber::getValue)
                .sum();
    }

    public static int sum(int[] number){
        return new Numbers(number).sum();
    }
}
