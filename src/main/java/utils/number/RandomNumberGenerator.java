package utils.number;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Override
    public int generate() {
        Random random = new Random();
        int number = random.nextInt(10);
        isValidRange(number);
        return number;
    }

    private void isValidRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(String.valueOf(number));
        }
    }
}
