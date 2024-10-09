package racingcar.domain;

public class Race {
    private final Cars cars;
    private final Movement movement;
    public Race(Cars cars, Movement movement) {
        this.cars = cars;
        this.movement = movement;
    }

    public void run() {
        for (Car car : cars.getCars()) {
            car.move(movement.isMove());
        }
    }
}
