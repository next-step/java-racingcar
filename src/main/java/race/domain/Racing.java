package race.domain;

import java.util.List;

public class Racing {

    private final RacingCars racingCars;

    public Racing(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void play() {
        racingCars.step();
    }

    public List<Car> judgeWinners() {
        return racingCars.getMostMovingCars();
    }
}
