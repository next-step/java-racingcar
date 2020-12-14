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

    public RacingWinners judgeWinners() {
        List<Car> mostMovingCars = racingCars.getMostMovingCars();
        return new RacingWinners(mostMovingCars);
    }
}
