package racing;

public class RacingGame {
    private RacingCars racingCars;
    private int times;

    public RacingGame(RacingCars racingCars, int times) {
        this.racingCars = racingCars;
        this.times = times;
    }

    public void race() {
        for (int i = 0; i < times; i++) {
            racingCars.moveCars();
        }
    }
}
