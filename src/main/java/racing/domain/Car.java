package racing.domain;

import racing.domain.strategies.CarMoveStrategy;

public class Car implements Comparable<Car> {
    private static final int RUN_STEP = 1;
    private final Position position;
    private final CarName name;

    public Car(String nameOfCar) {
        name = new CarName(nameOfCar);
        position = new Position();
    }

    public void run(CarMoveStrategy carMoveStrategy) {
        if (carMoveStrategy.isMovable()) {
            position.add(RUN_STEP);
        }
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return new Position(this.position);
    }

    @Override
    public int compareTo(Car car) {
        return getPosition().compareTo(car.getPosition());
    }
}
