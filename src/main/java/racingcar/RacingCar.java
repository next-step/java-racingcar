package racingcar;

import java.util.List;

public class RacingCar {
    public static final int CAR_MOVE_STANDARD = 4;
    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final int PLUS_VALUE = 1;

    public boolean moveYn(int randomNumber) {
        return randomNumber >= CAR_MOVE_STANDARD;
    }

    private void initMoveCounts(List<Integer> moveCounts, int carCount) {
        for (int i = BEGIN_INDEX; i < carCount; i++) {
            initMoveCount(moveCounts);
        }
    }

    private boolean initMoveCount(List<Integer> moveCounts) {
        return moveCounts.add(INIT_VALUE);
    }

    public void createMoveCounts(List<Integer> moveCounts, int carCount) {
        initMoveCounts(moveCounts, carCount);

        for (int i = BEGIN_INDEX; i < carCount; i++) {
            createMoveCount(moveCounts, i);
        }
    }

    private void createMoveCount(List<Integer> moveCounts, int idx) {
        if (moveYn()) {
            plusMoveCount(moveCounts, idx);
        }
    }

    private int plusMoveCount(List<Integer> moveCounts, int idx) {
        return moveCounts.set(idx, moveCounts.get(idx) + PLUS_VALUE);
    }

    private boolean moveYn() {
        return moveYn(getRandomNumber());
    }

    private int getRandomNumber() {
        return new RandomGenerator().getRandomNumber();
    }
}
