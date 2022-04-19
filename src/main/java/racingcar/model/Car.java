package racingcar.model;

import racingcar.strategy.MovingStrategy;

public class Car implements Comparable<Car> {
    private Position position;
    private MovingStrategy movingStrategy;
    private CarName carName;

    public Car(Position position, MovingStrategy movingStrategy, String name) {
        this(position, movingStrategy, new CarName(name));
    }

    Car(Position position, MovingStrategy movingStrategy, CarName carName) {
        this.position = position;
        this.movingStrategy = movingStrategy;
        this.carName = carName;
    }

    public static Car create(Position position, MovingStrategy movingStrategy, String name) {
        return new Car(position, movingStrategy, name);
    }

    public void move() {
        if (movingStrategy.decideWhetherToMove()) {
            position.increaseValue();
        }
    }

    public int getCurrentPosition() {
        return position.getValue();
    }

    public String getCarName() {
        return carName.getName();
    }

    public boolean compareWithMaxPosition(int maxPosition) {
        return this.position.getValue() == maxPosition;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position.getValue() - otherCar.position.getValue();
    }
}
