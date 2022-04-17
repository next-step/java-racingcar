package model;

public class Car {
    private Position position;

    public Car(Position position) {
        this.position = position;
    }

    public void move(MoveRule moveRule) {
        if (moveRule.isMoveForward()) {
            this.position.plus();
        }
    }

    public Position getPosition() {
        return position;
    }
}
