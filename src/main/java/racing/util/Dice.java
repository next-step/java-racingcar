package racing.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    public static int cast() {
        return new Random().nextInt(10);
    }

    public static List<Integer> castByCarCount(int carCount) {
        List<Integer> castResultList = new ArrayList<>();
        for (int i = 0 ; i < carCount ; i ++) {
            castResultList.add(cast());
        }

        return castResultList;
    }
}
