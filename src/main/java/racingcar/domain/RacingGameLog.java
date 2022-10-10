package racingcar.domain;

public class RacingGameLog {

    private final RacingCars racingCars;

    public RacingGameLog(RacingCars racingCars) {
        this.racingCars = new RacingCars(racingCars);
    }

    public RacingCars getRacingCars() {
        return this.racingCars;
    }
}
