package racingcar.domain;

import racingcar.policy.CarMovementPolicy;
import racingcar.vo.CarName;
import racingcar.vo.CarPosition;

public class Car {

    private final CarName name;
    private final CarPosition position;

    public Car(String name, CarPosition position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(String name) {
        return new Car(name, CarPosition.initialize());
    }

    public Car move(CarMovementPolicy policy) {
        if (policy.isMovable()) {
            return new Car(this.name, this.position.move());
        }
        return this;
    }

    public int getPositionValue() {
        return this.position.getValue();
    }

    public CarPosition getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name.getValue();
    }
}
