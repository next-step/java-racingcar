package racing;

public class RacingGame {

    private final Roulette roulette;

    private RacingCars racingCars;

    private int round;

    public RacingGame() {
        roulette = new Roulette();
    }

    public void start() {
        set();
        race();
    }

    private void set() {
        InputView.openScanner();

        final int carCount = InputView.readCarCount();
        this.racingCars = new RacingCars(carCount);

        this.round = InputView.readRound();

        InputView.closeScanner();
    }

    private void race() {
        ResultView.viewMessage();

        for (int i = 0; i < round; i++) {
            this.racingCars.race(roulette);
            ResultView.viewRoundResult(this.racingCars);
        }
    }
}
