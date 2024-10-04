package race;

import java.util.ArrayList;
import java.util.List;

public class CarRaceGameHistory {
    private final int round;
    private final int step;

    private CarRaceGameHistory(int round, int step) {
        this.round = round;
        this.step = step;
    }

    public int getStep() {
        return this.step;
    }

    public int getRound() {
        return this.round;
    }

    public static CarRaceGameHistory record(int round, int step) {
        return new CarRaceGameHistory(round, step);
    }
}
