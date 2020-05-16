package racingcar.domain;

import racingcar.moving.MovingStrategy;

import java.util.List;

public class Racing {

    private Cars cars;
    private Round round;

    public static Racing of(final Cars cars, final Round round) {
        return new Racing(cars, round);
    }

    private Racing() {
    }

    private Racing(final Cars cars, final Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void run(final MovingStrategy movingStrategy) {
        cars.moveCars(movingStrategy);
        round = round.nextRound();
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }

    public List<Car> getWinnerCars() {
        return this.cars.getWinnerCars();
    }

    public boolean isGameOver() {
        return round.isEndRound();
    }
}
