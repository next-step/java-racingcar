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
        cycle.minusCycle();
        cars.move(racingRandom);
    }

    public boolean isEnd() {
        return cycle.isEnd();
    }

    public List<Car> selectWinners() {
        return cars.selectWinners();
    }

    public Cars getCars() {
        return cars;
    }
}
