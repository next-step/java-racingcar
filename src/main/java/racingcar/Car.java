package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private List<Integer> carPositions = new ArrayList<>();
    private int position = 0;

    public List<Integer> getCarPositions() {
        return carPositions;
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
        carPositions.add(position);
    }

    private boolean isMovable(int value) {
        return value >= MOVE_CONDITION;
    }

}
