package racing;

public class RacingGame {

    private final InputView inputView;

    private RacingCars racingCars;

    private int round;

    public RacingGame() {
        this.inputView = new InputView();
    }

    public void set() {
        final int carCount = inputView.readCarCount();
        this.racingCars = new RacingCars(carCount);

        this.round = inputView.readRound();

        inputView.closeScanner();
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
