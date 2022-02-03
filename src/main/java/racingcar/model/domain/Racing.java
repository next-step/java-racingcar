package racingcar.model.domain;

public class Racing {

    private Cars cars;
    private CarMoveBehavior carMoveBehavior;

    public Racing(Cars cars, final CarMoveBehavior carMoveBehavior) {
        this.cars = cars;
        this.carMoveBehavior = carMoveBehavior;
    }

    public void drive() {

        cars.cars().stream()
            .forEach(car -> racingCondition(car));
    }

    private void racingCondition(Car car) {
        if (carMoveBehavior.moveBehavior()) {
            car.moveForward();
        }
    }
}

