package racingcar.utility;

public class RandomUtility {
    public static final int RANDOM_RANGE= 10;

    private RandomUtility() {
    }

    public static int getRandomNumber() {
        return (int) Math.floor(Math.random()*RANDOM_RANGE);
    }
}
