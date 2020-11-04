package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

    private final Roulette roulette;

    private RacingCars racingCars;

    private int round;

    public RacingGame(Roulette roulette) {
        this.roulette = roulette;
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
