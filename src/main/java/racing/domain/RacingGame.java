package racing.domain;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

    private final Roulette roulette;

    private RacingCars racingCars;

    private final Records records;

    private int round;

    public RacingGame(Roulette roulette) {
        this.roulette = roulette;
        this.records = new Records();
    }

    public void start() {
        set();
        race();
    }

    private void set() {
        InputView.openScanner();

        setRacingCars();
        setRound();

        InputView.closeScanner();
    }

    private void setRacingCars() {
        final String delimitedCarNames = InputView.readCarNames();
        this.racingCars = new RacingCars(delimitedCarNames);
    }

    private void setRound() {
        this.round = InputView.readRound();
    }

    private void race() {
        viewMessage();
        raceAndViewRondResult();
        viewWinner();
    }

    private void viewMessage() {
        ResultView.viewMessage();
    }

    private void raceAndViewRondResult() {
        for (int i = 0; i < round; i++) {
            this.racingCars.race(this.roulette);
            records.recordRound(racingCars);
            ResultView.viewRoundResult(records);
        }
    }


    private void viewWinner() {
        ResultView.viewWinner(records.findWinners());
    }
}
