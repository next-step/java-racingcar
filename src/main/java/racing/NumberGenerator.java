package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    private final static Random random = new Random();
    public static List<Integer> generateRandomList(int carCount) {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            randomList.add(random.nextInt(10));
        }
        return randomList;
    }
}
