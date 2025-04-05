package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRecord {

    private static final int SEQUENCE_INIT = 0;

    private final int sequence;
    private final Cars cars;

    public RaceRecord(Cars cars) {
        this.sequence = SEQUENCE_INIT;
        this.cars = cars;
    }

    public RaceRecord(int sequence, Cars cars) {
        this.sequence = sequence;
        this.cars = cars;
    }

    public int getSequence() {
        return this.sequence;
    }

    public Cars getCars() {
        return this.cars;
    }

    public List<String> getWinnerNames() {
        return getCars().getValues()
            .stream()
            .filter(this::isMaxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private boolean isMaxPosition(Car car) {
        return getCars().getMaxPosition()
            .equals(car.getPosition());
    }
}
