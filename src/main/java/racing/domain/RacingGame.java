package racing.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;

    public Cars getCars() {
        return this.cars;
    }

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void moveCars() {
        cars.move();
    }

    public List<Car> getWinnerCars() {

        return new Judgement(cars).getWinnerCars();
    }
}