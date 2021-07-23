package racingcar.car;

import racingcar.view.ResultView;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move() {
        if (position.isMove()) {
            position.moveForward();
        }

        ResultView.printCarPositionStatus(position);
    }
}
