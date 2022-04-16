package racingcar.model;

public class Car {
    private Position position;
    private MovingStrategy movingStrategy;
    private String name;

    public Car(Position position, MovingStrategy movingStrategy, String name) {
        this.position = position;
        this.movingStrategy = movingStrategy;
        this.name = name;
    }

    public void move() {
        if (movingStrategy.decideWhetherToMove()) {
            position.increaseValue();
        }
    }

    public int currentPosition() {
        return position.getValue();
    }

    public String getName() {
        return name;
    }
}
