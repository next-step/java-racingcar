package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int RANDOM_UPPER_BOUND = 10;

    private RandomGenerator() {
        throw new AssertionError();
    }

    public static List<Integer> generateRandomsOfSize(int size) {
        List<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randoms.add(RANDOM_GENERATOR.nextInt(RANDOM_UPPER_BOUND));
        }
        return randoms;
    }

}
