package racing;

import java.util.Arrays;
import java.util.Random;

public class RacingGame {
    private final int BOUND = 9;
    private final int CONDITION = 4;

    private int time;
    private int[] carPositions;

    public RacingGame(int[] carPositions) {
        this.carPositions = carPositions;
    }

    public int[] move() {
        return Arrays.stream(carPositions).map(v -> move(v)).toArray();
    }

    protected int move(int position) {
        if (canMove()) {
            return ++position;
        }

        return position;
    }

    protected boolean canMove() {
        return new Random().nextInt(BOUND) >= CONDITION;
    }

}
