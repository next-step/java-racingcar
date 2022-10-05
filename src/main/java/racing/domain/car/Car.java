package racing.domain.car;


import racing.domain.car.movingstrategy.MovingStrategy;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
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
        return name.getNameValue();
    }

    public int getPosition() {
        return position.getPositionValue();
    }

    private boolean isLeadingThan(Car comparedCar) {
        return comparedCar == null || position.isBiggerThan(comparedCar.position);
    }

    public boolean isSamePosition(Car other) {
        return this.position.equals(other.position);
    }
}
