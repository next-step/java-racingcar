package racing;

public class Car {

    private final Position position;
    private final MoveStrategy strategy;

    public Car(MoveStrategy strategy) {
        this.position = new Position();
        this.strategy = strategy;
    }

    public void forward() {
        position.addOne();
    }

    public boolean hasPosition(int value) {
        return position.equals(new Position(value));
    }

    public String carPosition() {
        return position.dashOfPosition();
    }

    public void play() {
        if (strategy.movable()) {
            forward();
        }
    }
}
