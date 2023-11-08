package racingcar.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Car> winners() {
        RaceRecord maxRaceRecord = findByMaxRaceRecord();

        return raceRecords.stream()
                .filter(raceRecord -> raceRecord.distance() == maxRaceRecord.distance())
                .map(RaceRecord::car)
                .collect(Collectors.toList());
    }

    private RaceRecord findByMaxRaceRecord() {
        Comparator<RaceRecord> comparatorByDistance = Comparator.comparingInt(RaceRecord::distance);
        RaceRecord maxRecord = raceRecords.stream()
                .max(comparatorByDistance)
                .orElseThrow(NoSuchFieldError::new);
        return maxRecord;
    }
}