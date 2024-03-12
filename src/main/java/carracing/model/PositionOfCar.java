package carracing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositionOfCar {
    private int position;
    private final List<Integer> positionHistory;

    public PositionOfCar() {
        this.position = 0;
        this.positionHistory = new ArrayList<>();
    }

    public int position() {
        return position;
    }

    public List<Integer> positionHistory() {
        return Collections.unmodifiableList(positionHistory);
    }

    public void increase(final int increaseAmount) {
        position += increaseAmount;
        positionHistory.add(position);
    }
}
