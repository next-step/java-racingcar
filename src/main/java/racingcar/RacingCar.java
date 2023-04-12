package racingcar;

import java.util.List;

public class RacingCar {
    private List<Integer> moveCounts;

    public RacingCar(List<Integer> moveCounts) {
        this.moveCounts = moveCounts;
    }

    public static final int CAR_MOVE_STANDARD = 4;
    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final int PLUS_VALUE = 1;


    public boolean moveYn(int randomNumber) {
        return randomNumber >= CAR_MOVE_STANDARD;
    }

    public List<Integer> getMoveCounts(int carCount) {
        for (int i = BEGIN_INDEX; i < carCount; i++) {
            createMoveCount(i);
        }

        return moveCounts;
    }

    public void initMoveCounts(int carCount) {
        for (int i = BEGIN_INDEX; i < carCount; i++) {
            initMoveCount();
        }
    }

    private boolean initMoveCount() {
        return moveCounts.add(INIT_VALUE);
    }

    private void createMoveCount(int idx) {
        if (moveYn()) {
            plusMoveCount(idx);
        }
    }

    private boolean moveYn() {
        return moveYn(getRandomNumber());
    }

    private int plusMoveCount(int idx) {
        return moveCounts.set(idx, moveCounts.get(idx) + PLUS_VALUE);
    }

    private int getRandomNumber() {
        return new RandomGenerator().getRandomNumber();
    }
}
