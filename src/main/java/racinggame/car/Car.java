package racinggame.car;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final String RACE_STATUS_STRING = "-";
    private static final int MOVABLE_NUMBER = 4;
    private static final int STARTING_POSITION = 0;
    private int position;
    private final List<String> status;
    private final StringBuilder stringBuilder;

    public Car() {
        position = STARTING_POSITION;
        status = new ArrayList<>();
        stringBuilder = new StringBuilder();
    }

    public boolean race(int num) {
        boolean movable = isMovable(num);
        if (movable) {
            position++;
        }
        recordGameHistory();

        return movable;
    }

    public int getPosition() {
        return position;
    }

    public List<String> getStatus() {
        return status;
    }

    private void recordGameHistory() {
        stringBuilder.setLength(0);
        for (int i = 0; i < position; i++) {
            stringBuilder.append(RACE_STATUS_STRING);
        }
        status.add(stringBuilder.toString());
    }

    private boolean isMovable(int num) {
        return num >= MOVABLE_NUMBER;
    }
}
