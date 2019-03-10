package racingcar;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private Random random = new Random();

    public int[] generateNumbers(int count) {
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(10);
        }
        return numbers;
    }
}
