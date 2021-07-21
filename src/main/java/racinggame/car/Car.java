package racinggame.car;

import racinggame.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final String RACE_STATUS_STRING = "-";
    private static final int STARTING_POSITION = 0;
    private int position;
    private final List<String> status;
    private final StringBuilder stringBuilder;

    public Car() {
        position = STARTING_POSITION;
        status = new ArrayList<>();
        stringBuilder = new StringBuilder();
    }

    public void race(MovingStrategy strategy) {
        if (strategy.isMove()) {
            position++;
        }
        recordGameHistory();
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
}
