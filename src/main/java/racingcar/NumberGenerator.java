package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public static final int RANDOM_NEXT_INT_BOUND = 10;
    private final Random random;

    public NumberGenerator() {
        this.random = new Random();
    }

    public int generateRandomNumber() {
        return random.nextInt(RANDOM_NEXT_INT_BOUND);
    }

    public List<Integer> generateRandomNumbers(int roundCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            randomNumbers.add(this.generateRandomNumber());
        }

        return randomNumbers;
    }
}
