package racingcar;




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
        racingCars.moveCar(new RandomMove());
    }

    public void showRacingResult() {
        RacingResultView.viewResult(racingCars);
    }
}
