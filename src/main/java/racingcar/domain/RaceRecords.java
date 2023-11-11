package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceRecords {
    private final List<RaceRecord> raceRecords;

    public RaceRecords(List<RaceRecord> raceRecords) {
        this.raceRecords = new ArrayList<>(raceRecords);
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

    public List<RaceRecord> getRaceRecords() {
        return Collections.unmodifiableList(raceRecords);
    }
}