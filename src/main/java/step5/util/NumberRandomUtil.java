package step5.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NumberRandomUtil {

    private static final Random random = new Random();
    private static final int BOUND = 10;

    public static int generate() {
        return random.nextInt(BOUND);
    }

    public static List<Integer> generateList(int number) {
        List<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            randomNums.add(generate());
        }
        return randomNums;
    }
}
