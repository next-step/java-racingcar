package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void tryMove() {
        racingCars.tryMove();
    }

    public List<Car> getWinners(){
        return racingCars.getWinners();
    }

    public List<Car> getCars() {
        return racingCars.getCars();
    }
}
