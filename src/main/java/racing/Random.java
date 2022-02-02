package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Random {

    public static List<Integer> getRandomNumbers(final int length) {
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            randomNumbers.add(getMoveRandomNumber());
        }
        return randomNumbers;
    }

    public static List<Integer> getRandomNumbers(final int[] seeds) {
        List<Integer> randomNumbers = new ArrayList<>();
        Arrays.stream(seeds)
            .forEach(seed -> randomNumbers.add(seed));
        return randomNumbers;
    }

    public static int getMoveRandomNumber() {
        return (int) ((Math.random() * (10)));
    }
}
