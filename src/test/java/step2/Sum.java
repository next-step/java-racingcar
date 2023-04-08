package step2;

import java.util.Arrays;

public class Sum {

    private final int[] ints;

    public Sum(int[] ints) {
        for (int number : ints) {
            validateNagative(number);
        }
        this.ints = ints;
    }

    public int getResult() {
        return Arrays.stream(ints).sum();
    }

    private void validateNagative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다.");
        }
    }
}
