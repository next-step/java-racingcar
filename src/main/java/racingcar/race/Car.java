package racingcar.race;

import racingcar.domain.CarName;
import racingcar.domain.Position;
import racingcar.domain.RaceRecord;

public class Car {
    private final CarName name;
    private final Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public void move() {
        position.move();
    }

    public RaceRecord record() {
        return new RaceRecord(this);
    }

    public CarName name() {
        return name;
    }

    public Position position() {
        return position;
    }
}
