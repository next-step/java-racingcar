package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberFactory {

    public static List<Integer> getRandomNumbers(int size) {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(random.nextInt(10));
        }
        return randomNumbers;
    }
}
