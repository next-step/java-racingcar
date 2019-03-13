package racing;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private int moveCount;
    private Map<Integer, Integer> carTimeTable;

    public Car() {
        this.moveCount = 0;
        carTimeTable = new HashMap<Integer, Integer>();
    }

    public void move(final boolean carMoveTrueAndFalse, final int time) {
        if (carMoveTrueAndFalse) {
            moveCount += 1;
        }

        carTimeTable.put(time, moveCount);
    }

    public Map<Integer, Integer> getMoveValues() {
        return carTimeTable;
    }
}
