package racingcar;

public class RacingCar {
    private static final int RANDOM_BOUND = 10;
    private static final int MIN_MOVABLE_NUM = 4;

    private final RandomUtil randomUtil;
    private final int numberOfCountToTry;
    private int moveCount;

    public RacingCar(int numberOfCountToTry) {
        this.randomUtil = JavaUtilRandom.getInstance();
        this.numberOfCountToTry = numberOfCountToTry;
        moveCount = 0;
    }

    public RacingCar(RandomUtil randomUtil, int numberOfCountToTry) {
        this.randomUtil = randomUtil;
        this.numberOfCountToTry = numberOfCountToTry;
        moveCount = 0;
    }

    public void tryToMove() {
        int i = randomUtil.getInt(RANDOM_BOUND);

        if (moveCount >= numberOfCountToTry) {
            return;
        }

        if (i >= MIN_MOVABLE_NUM) {
            moveCount++;
        }
    }

    public void printProcess(StringBuilder sb) {
        for (int i = 0; i < moveCount; i++) {
            sb.append("-");
        }
    }
}
