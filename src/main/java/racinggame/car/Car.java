package racinggame.car;

public class Car {

    private Position position;

    public Car() {
        this.position = Position.of();
    }

    public void move(final MoveStrategy moveStrategy) {

    }

    public int getPosition() {
        return position.value();
    }

}
