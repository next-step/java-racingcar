package racingcar.domain;

import racingcar.domain.status.CarMoveAbility;
import racingcar.domain.status.MoveAbility;

public class Car {
    private static final int START_POSITION = 0;

    private final String name;
    private int position;
    private final MoveAbility moveAbility;

    public Car(String name, int position, MoveAbility moveAbility) {
        this.name = name;
        this.position = position;
        this.moveAbility = moveAbility;
    }

    public static Car of(String name) {
        return new Car(name, START_POSITION, new CarMoveAbility());
    }

    public void move() {
        if (moveAbility.hasMoveAbility()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public boolean isFirstPosition(Car car) {
        return this.position == car.position;
    }
}
