package racingcar.domain;

public class Car {

    private Position position;

    public Car() {
        this.position = Position.start();
    }

    public void moveForward(RandomMoveStrategy strategy) {
        if (strategy.movable()) {
            position = position.move();
        }
    }

    public Position getPosition() {
        return position;
    }


}

