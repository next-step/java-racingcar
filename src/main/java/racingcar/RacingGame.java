package racingcar;

import java.util.List;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void tryMove() {
        racingCars.tryMove();
    }

    public List<Integer> getPositions(){
        return racingCars.getPositions();
    }
}
