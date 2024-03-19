package racingcar;


import java.util.concurrent.ThreadLocalRandom;

public class RacingCarGame {

    private final RacingCars racingCars;
    private int tryCount = 0;

    public RacingCarGame(RacingCars racingCars, int tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    public void playRacingGame() {
        for (int i = 0; i < tryCount; i++) {
            moveCar();
        }
    }

    private void moveCar() {
        racingCars.moveCar(new RandomStrategy() {
            @Override
            public int create() {
                return ThreadLocalRandom.current().nextInt(1, 10);
            }
        });
    }

    public void showRacingResult() {
        RacingResultView.viewResult(racingCars);
    }
}
