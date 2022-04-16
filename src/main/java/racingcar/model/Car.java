package racingcar.model;

public class Car {
    private Position position;
    private MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.position = new Position();
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.decideWhetherToMove()) {
            position.increaseValue();
        }
    }


    public int currentPosition() {
        return position.getValue();
    }
}
