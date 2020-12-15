package step3;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int INIT_DISTANCE = 0;

    private int distance;
    private List<Round> roundHistory = new ArrayList<>();

    public Car() {
        this.distance = INIT_DISTANCE;
    }

    public void move(int roundTime, boolean canMove) {
        if(canMove) {
            this.distance++;
        }

        addRoundHistory(roundTime);
    }

    private void addRoundHistory(int roundTime) {
        roundHistory.add(new Round(roundTime, this.distance));
    }

    public int getDistance() {
        return distance;
    }

    public List<Round> getRoundHistory() {
        return roundHistory;
    }
}
