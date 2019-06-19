package racing.model;

import java.util.List;

public class RacingGame {

    private List<Car> cars;

    private RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingGame of(List<Car> cars) {
        return new RacingGame(cars);
    }


    public void run() {
        movingCars();

    }

    private void movingCars() {
        this.cars.forEach(this::moveWhenHigher4);
    }

    private void moveWhenHigher4(Car car) {
        if (RandomNumberCreator.getZeroToNine() >= 4) car.move();
    }


    public List<Car> getCars() {
        return this.cars;
    }

}
