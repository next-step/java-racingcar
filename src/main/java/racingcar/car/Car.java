package racingcar.car;

import racingcar.util.Util;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move() {
        int randomNumber = Util.generateRandom();
        if (position.canMove(randomNumber)) {
            position.moveForward();
        }
    }

    public Position getPosition() {
        return this.position;
    }
}
