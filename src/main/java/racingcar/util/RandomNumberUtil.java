package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberUtil {

    private RandomNumberUtil() {}

    private static final int RANDOM_BOUND_NUMBER = 10;

    public static int generateRandomNumber() {
        return new Random().nextInt(RANDOM_BOUND_NUMBER);
    }

    public static List<Integer> generateRandomNumberList(int size) {
        List<Integer> randomNumbers = new ArrayList<>();

        int count = 0;
        while (count < size) {
            randomNumbers.add(generateRandomNumber());
            count++;
        }

        return randomNumbers;
    }
}
