package step3.model;

import step3.Car;

import java.util.List;

public class RacingCarGame {
    private Cars cars;

    public RacingCarGame(int CarCount) {
        this.cars = new Cars(CarCount);
    }

    public RacingCarGame(String... names) {
        this.cars = new Cars(names);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void play(MovingStrategy movingStrategy) {
        cars.move(movingStrategy);
    }
}
