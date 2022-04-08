package step03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    public static final int RANDOM_BOUND_NUMBER = 10;
    private final Random random = new Random();

    public int generateRandomNumber() {
        return random.nextInt(RANDOM_BOUND_NUMBER);
    }

    public List<Integer> generateRandomNumberList(int size) {
        List<Integer> randomNumbers = new ArrayList<>();

        int count = 0;
        while (count < size) {
            randomNumbers.add(generateRandomNumber());
            count++;
        }

        return randomNumbers;
    }
}
