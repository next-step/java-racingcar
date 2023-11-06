package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static final int BOUND = 10;
    private final RandomService randomService;

    public RacingGame(RandomService randomService) {
        this.randomService = randomService;
    }

    public List<RacingCar> startGame(List<RacingCar> racingCars) {
        raceOnce(racingCars);
        return racingCars;
    }

    private void raceOnce(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> racingCar.move(randomService.nextInt(BOUND)));
    }
}
