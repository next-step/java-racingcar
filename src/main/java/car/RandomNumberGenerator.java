package car;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final Random random = new Random();

    public Integer makeRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public List<Integer> makeRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(makeRandomNumber());
        }
        return randomNumbers;
    }

}
