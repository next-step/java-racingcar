package racing;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public boolean hasPosition(int value) {
        return position.equals(new Position(value));
    }

    public String carPosition() {
        return position.dashOfPosition();
    }

    public void play(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position.addOne();
        }
    }

}
