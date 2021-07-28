package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private List<Lap> laps = new ArrayList<>();

    public List<Lap> getLaps() {
        return laps;
    }

    public void recordLap(List<Car> cars) {
        laps.add(new Lap(cars));
    }
}
