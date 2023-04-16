package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final int CAR_MOVE_STANDARD = 4;
    public static final int PLUS_VALUE = 1;

    private List<Integer> moveCounts;

    public RacingCar(int carCount) {
        List<Integer> moveCounts = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < carCount; i++) {
            moveCounts.add(INIT_VALUE);
        }
        this.moveCounts = moveCounts;
    }

    public List<Integer> makeMoveCounts(List<Integer> numbers) {
        for (int i = BEGIN_INDEX; i < numbers.size(); i++) {
            makeMoveCount(i, numbers.get(i));
        }
        return moveCounts;
    }

    private void makeMoveCount(int idx, int number) {
        if (isCarMovable(number)) {
            plusMoveCount(idx);
        }
    }

    public boolean isCarMovable(int number) {
        return number >= CAR_MOVE_STANDARD;
    }

    private void plusMoveCount(int idx) {
        moveCounts.set(idx, moveCounts.get(idx) + PLUS_VALUE);
    }
}
