package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static RandomNumber randomNumber = new RandomNumber();

    private Cars cars;
    private Cycle cycle;

    public RacingGame(Cars cars, Cycle cycle) {
        this.cars = cars;
        this.cycle = cycle;
    }

    public void race() {
        this.cycle.minus();
        this.cars.move(randomNumber);
    }

    public boolean isPlaying() {
        return this.cycle.isPlaying();
    }

    public List<Car> selectWinners() {
        return this.cars.selectWinners();
    }

    public Cars getCars() {
        return this.cars;
    }
}
