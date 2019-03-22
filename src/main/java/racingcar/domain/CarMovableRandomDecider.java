package racingcar.domain;

public class CarMovableRandomDecider implements CarMovableDecider {

    private static final int RANDOM_FROM = 0;
    private static final int RANDOM_TO = 9;

    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean movable() {
        int randomValue = new RandomUtil(RANDOM_FROM, RANDOM_TO).randomInt();

        if (randomValue > MOVE_THRESHOLD) {
            return true;
        }
        return false;
    }

}
