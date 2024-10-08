package racingcar;

public class Race {
    private final Cars cars;
    Race(Cars cars) {
        this.cars = cars;
    }

    public void run() {
        for (Car car : cars.getCars()) {
            Movement movement = new RandomMovement();
            car.move(movement.isMove());
        }
    }
}
