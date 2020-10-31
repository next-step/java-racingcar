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
        this.racingCars.ready();
    }

    public void race() {
        ResultView.viewMessage();

        for (int i = 0; i < round; i++) {
            this.racingCars.race();
            ResultView.viewRoundResult(this.racingCars);
        }
    }
}
