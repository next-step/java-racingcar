package racing.race;

import java.util.ArrayList;
import java.util.List;

public class RaceCar {

    private final List<RaceGauge> results = new ArrayList<>();

    public void race(boolean isForward) {
        results.add(isForward ? RaceGauge.FORWARD : RaceGauge.STOP);
    }

    public RaceRecord raceRecord() {
        return new RaceRecord(List.copyOf(results));
    }
}
