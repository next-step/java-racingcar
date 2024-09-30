package racing.race;

import java.util.ArrayList;
import java.util.List;

public class RaceCar {

    private final List<RacePosition> results = new ArrayList<>();

    private final String name;

    public RaceCar(String name) {
        this.name = name;
    }

    public void race(boolean isForward) {
        results.add(isForward ? RacePosition.FORWARD : RacePosition.STOP);
    }

    public RaceRecord raceRecord() {
        return new RaceRecord(name, List.copyOf(results));
    }
}
