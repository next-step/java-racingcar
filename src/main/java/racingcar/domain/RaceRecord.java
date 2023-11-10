package racingcar.domain;

import racingcar.race.Car;

import java.util.Objects;

public class RaceRecord {
    private final CarName carName;
    private final Position position;

    public RaceRecord(Car car) {
        this(car.name(), car.position());
    }

    public RaceRecord(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public CarName carName() {
        return carName;
    }

    public Position position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceRecord that = (RaceRecord) o;
        return Objects.equals(carName, that.carName) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
