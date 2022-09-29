package racingcar.domain;

import racingcar.domain.movingcondition.MovingCondition;

public class Car {

    private int position;

    public static Car createInitialOne() {
        return new Car(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public int move(MovingCondition condition) {
        if (condition.canMove()) {
            position++;
        }
        return position;
    }
}
