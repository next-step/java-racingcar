package racingcar.race;

import racingcar.domain.Position;

public class RaceRecord {
    private final Car car;
    private final Position position;

    public RaceRecord(Car car) {
        this.car = car;
        this.position = car.position();
    }

    public Car car() {
        return car;
    }

    public Position position() {
        return position;
    }
}
