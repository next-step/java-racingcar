package racingcar.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceRecords {
    private final List<RaceRecord> raceRecords;

    public RaceRecords() {
        this.raceRecords = new ArrayList<>();
    }

    public void record(List<Car> cars) {
        for (Car car : cars) {
            add(car);
        }
    }

    private void add(Car car) {
        add(new RaceRecord(car));
    }

    private void add(RaceRecord raceRecord) {
        raceRecords.add(raceRecord);
    }

    public List<RaceRecord> list() {
        return Collections.unmodifiableList(raceRecords);
    }
}