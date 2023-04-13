package race;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int laps;
    private final Cars cars;

    public Race(int laps, Cars cars) {
        this.laps = laps;
        this.cars = cars;
    }

    public RaceResult start() {
        List<MoveResults> result = new ArrayList<>();
        for (int i = 0; i < laps; i++) {
            result.add(cars.orderMove());
        }
        return new RaceResult(result);
    }
}
