package racingcar.car;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move(int randomNumber) {
        if (position.isMove(randomNumber)) {
            position.moveForward();
        }
    }

    public Position getPosition() {
        return this.position;
    }
}
