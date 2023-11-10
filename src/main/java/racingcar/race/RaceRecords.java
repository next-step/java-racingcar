package racingcar.race;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Position;
import racingcar.domain.RaceRecord;

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
        add(car.record());
    }

    private void add(RaceRecord raceRecord) {
        raceRecords.add(raceRecord);
    }

    public List<RaceRecord> list() {
        return Collections.unmodifiableList(raceRecords);
    }

    public List<CarName> winners() {
        Position positionMax = positionMax();

        return raceRecords.stream()
                .filter(raceRecord -> positionMax.equals(raceRecord.position()))
                .map(RaceRecord::carName)
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