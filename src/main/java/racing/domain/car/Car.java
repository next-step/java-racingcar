package racing.domain.car;


import racing.domain.movingstrategy.MovingStrategy;

public class Car {

    private final CarName carName;
    private Position position;

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, 0);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position = position.move();
        }
    }

    public Car leading(Car comparedCar) {
        if (isLeadingThan(comparedCar)) {
            return this;
        }
        return comparedCar;
    }

    public String getName() {
        return carName.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    private boolean isLeadingThan(Car comparedCar) {
        return comparedCar == null || position.isBiggerThan(comparedCar.position);
    }

    public boolean isSamePosition(Car other) {
        return this.position.equals(other.position);
    }
}
