package racingcar;

public class Random {

    private static final int BOUND = 10;
    private static final int MIDDLE_NUMBER = 4;
    private static final java.util.Random random = new java.util.Random();

    public static int randomMove() {
        if (random.nextInt(BOUND) > MIDDLE_NUMBER) {
            return 1;
        }
        return 0;
    }
}
