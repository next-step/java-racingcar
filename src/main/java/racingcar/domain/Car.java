package racingcar.domain;

import racingcar.domain.status.CarMoveAbility;
import racingcar.domain.status.MoveAbility;

public class Car {
    private static final int START_POSITION = 0;

    private int position;
    private final MoveAbility moveAbility;

    public Car() {
        this.position = START_POSITION;
        this.moveAbility = new CarMoveAbility();
    }

    public Car(MoveAbility moveAbility) {
        this.position = START_POSITION;
        this.moveAbility = moveAbility;
    }

    public void move(int number) {
        if (moveAbility.hasMoveAbility(number)) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
