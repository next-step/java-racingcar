package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomValueGenerator {

    private static final int MAX_BOUND = 10;

    private static List<Integer> randomValues;

    public static List<Integer> getRandomValues(int count) {
        randomValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomValues.add(generateRandomValue());
        }
        return randomValues;
    }

    private static int generateRandomValue() {
        return new Random().nextInt(MAX_BOUND);
    }
}
