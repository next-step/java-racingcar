package race;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int lap;
    private final Cars cars;

    public Race(int lap, Cars cars) {
        this.lap = lap;
        this.cars = cars;
    }

    public List<List<Boolean>> start() {
        List<List<Boolean>> result = new ArrayList<>();
        for (int i = 0; i < lap; i++) {
            result.add(cars.orderMove());
        }
        return result;
    }
}
