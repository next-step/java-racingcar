package racingGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    public static final int BOUND = 10;

    public static final Random random = new Random();

    public static List<Integer> makeRandomNumber(int count) {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumberList.add(random.nextInt(BOUND));
        }
        return randomNumberList;
    }

}
