package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static RacingRandom racingRandom = new RacingRandom();

    private Cars cars;
    private Cycle cycle;

    public RacingGame(Cars cars, int cycle) {
        this.cars = cars;
        this.cycle = new Cycle(cycle);
    }

    public void race() {
        this.cycle.minusCycle();
        this.cars.move(racingRandom);
    }

    public boolean isEnd() {
        return this.cycle.isEnd();
    }

    public List<Car> selectWinners() {
        return this.cars.selectWinners();
    }

    public Cars getCars() {
        return this.cars;
    }
}
