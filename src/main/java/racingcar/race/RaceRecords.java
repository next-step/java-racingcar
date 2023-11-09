package racingcar.race;

import racingcar.domain.Position;

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
        Position positionMax = positionMax();

        return raceRecords.stream()
                .filter(raceRecord -> positionMax.same(raceRecord.position()))
                .map(RaceRecord::car)
                .collect(Collectors.toList());
    }

    private Position positionMax() {
        Comparator<Position> comparatorByPosition = Comparator.comparingInt(Position::value);
        return raceRecords.stream()
                .map(RaceRecord::position)
                .max(comparatorByPosition)
                .orElseThrow(NoSuchFieldError::new);
    }
}