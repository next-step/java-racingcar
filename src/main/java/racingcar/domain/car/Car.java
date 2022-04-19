package racingcar.domain.car;

import racingcar.domain.car.strategy.CarActionStrategy;

public class Car {
    private static final int MOVABLE_DISTANCE = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private int position = 0;
    private final String name;
    private final CarActionStrategy carActionStrategy;

    public Car(String name, int position, CarActionStrategy carActionStrategy) {
        validateCar(name, carActionStrategy);
        this.name = name;
        this.position = position;
        this.carActionStrategy = carActionStrategy;
    }

    public Car(String name, CarActionStrategy carActionStrategy) {
        validateCar(name, carActionStrategy);
        this.name = name;
        this.carActionStrategy = carActionStrategy;
    }

    private void validateCar(String name, CarActionStrategy carActionStrategy) {
        if (isNotValidName(name)) {
            throw new IllegalArgumentException(String.format("name(%s)이 올바르지 않습니다.", name));
        }

        if (carActionStrategy == null) {
            throw new IllegalArgumentException("CarActionStrategy없이 Car는 생성될 수 없습니다.");
        }
    }

    private boolean isNotValidName(String name) {
        return name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    private Car goForward() {
        return new Car(this.name, position + MOVABLE_DISTANCE, carActionStrategy);
    }

    public Car act() {
        if (carActionStrategy.isMovable()) {
            return goForward();
        }
        return this;
    }
}
