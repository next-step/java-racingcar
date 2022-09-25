package racingcar.domain;

import racingcar.domain.movingcondition.MovingCondition;

public class Car {

    private int position;

    public Car() {
        this(0);
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
