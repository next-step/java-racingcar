package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int DEFAULT_POSITION = 1;
    private static final int MOVABLE_CONDITION = 4;

    private int position;
    private List<Integer> history;

    public Car() {
        this.position = DEFAULT_POSITION;
        this.history = new ArrayList<>();
    }

    public int move(int random) {
        if (random >= MOVABLE_CONDITION) {
            return ++this.position;
        }
        return this.position;
    }

    public int getPosition() {
        return this.position;
    }

    public int getPositionHistory(int lapIndex) {
        return this.history.get(lapIndex);
    }
}
