package racingcar.model.domain;

public class Racing {

    private final Cars cars;
    private final CarMoveBehavior carMoveBehavior;

    public Racing(final Cars cars, final CarMoveBehavior carMoveBehavior) {
        this.cars = cars;
        this.carMoveBehavior = carMoveBehavior;
    }

    public void drive() {
        cars.drive(carMoveBehavior);
    }
}

