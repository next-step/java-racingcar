package domain;

import java.util.List;

public class Winners {
    private final List<Car> cars;

    public Winners(RacingGame racingGame) {
        this.cars = racingGame.findWinners();
    }

    public List<Car> getCars() {
        return cars;
    }
}
