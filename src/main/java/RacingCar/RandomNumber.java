package RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int RANDOM_NUMBER_RANGE = 10;

    public List<Integer> randomList(int size) {
        List<Integer> randomList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            randomList.add(random());
        }

        return randomList;
    }

    private int random() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
