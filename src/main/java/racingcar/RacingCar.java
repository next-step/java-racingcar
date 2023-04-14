package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public static final int CAR_MOVE_STANDARD = 4;
    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final int PLUS_VALUE = 1;

    private List<Integer> moveCounts;

    public RacingCar(int carCount) {
        List<Integer> moveCounts = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < carCount; i++) {
            moveCounts.add(INIT_VALUE);
        }

        this.moveCounts = moveCounts;
    }

    public List<Integer> makeMoveCounts(int carCount) {
        for (int i = BEGIN_INDEX; i < carCount; i++) {
            makeMoveCount(i);
        }
        return moveCounts;
    }

    private void makeMoveCount(int idx) {
        if (moveYn(getRandomNumber())) {
            plusMoveCount(idx);
        }
    }

    public boolean moveYn(int randomNumber) {
        return randomNumber >= CAR_MOVE_STANDARD;
    }

    private int getRandomNumber() {
        return new RandomGenerator().getRandomNumber();
    }

    private int plusMoveCount(int idx) {
        return moveCounts.set(idx, moveCounts.get(idx) + PLUS_VALUE);
    }
}
