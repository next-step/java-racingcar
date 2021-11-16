package racingcar.util;

public class NumberGenerator {

    private static final int BOUND = 10;
    private static final int MIDDLE_NUMBER = 4;
    private static final java.util.Random random = new java.util.Random();

    public int generate() {
        if (random.nextInt(BOUND) > MIDDLE_NUMBER) {
            return 1;
        }
        return 0;
    }
}
