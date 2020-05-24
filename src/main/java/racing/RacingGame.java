package racing;

public class RacingGame {
    private RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars race() {
        racingCars.moveCars();
        return racingCars;
    }
}
