package racingcar.domain;

import static racingcar.constant.Constant.BOUND;

import java.util.List;

public class RacingGame {
    private final RandomService randomService;

    public RacingGame(RandomService randomService) {
        this.randomService = randomService;
    }

    public List<RacingCar> startSingleGame(List<RacingCar> racingCars) {
        raceOnce(racingCars);
        return racingCars;
    }

    private void raceOnce(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> racingCar.move(randomService.nextInt(BOUND)));
    }
}
