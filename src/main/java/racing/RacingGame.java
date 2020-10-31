package racing;

public class RacingGame {

    private RacingCars racingCars;

    private int round;

    public RacingGame() {}

    public void set() {
        InputView.openScanner();

        final int carCount = InputView.readCarCount();
        this.racingCars = new RacingCars(carCount);

        this.round = InputView.readRound();

        InputView.closeScanner();
    }

    public void ready() {
        racingCars.enterCars();
    }

    public void race() {
        final RacingCars racingCars = this.racingCars;

        ResultView.viewMessage();

        for (int i = 0; i < round; i++) {
            startRound(racingCars);
            ResultView.viewRoundResult(racingCars);
        }
    }

    private void startRound(final RacingCars racingCars) {
        for (final Car car : racingCars.getCars()) {
            if (Roulette.spin() >= 4) {
                car.move();
            }
        }
    }
}
