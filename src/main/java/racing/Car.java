package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final int MOVE_CONDITION_NUMBER = 4;
    private final int MOVE_NUMBER = 1;
    private final int STOP_NUMBER = 0;

    public int position = 0;

    public void move(int movableValue) {
        position += isMovable(movableValue);
    }

    public int isMovable(int movableValue) {
        return (movableValue >= MOVE_CONDITION_NUMBER) ? MOVE_NUMBER : STOP_NUMBER;
    }
}
