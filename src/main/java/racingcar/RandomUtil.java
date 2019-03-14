package racingcar;

import java.util.Random;

public class RandomUtil {

    private int rangeFrom;
    private int rangeTo;

    public RandomUtil(int randomFrom, int randomTo) {
        this.rangeFrom = randomFrom;
        this.rangeTo = randomTo;
    }

    public int randomInt() {
        return new Random().nextInt(rangeTo - rangeFrom + 1) + rangeFrom;
    }
}