package racing.domain;

import java.util.ArrayList;
import java.util.List;

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

            List<Record> records = recordRound(racingCars);

            ResultView.viewRoundResult(records);
        }
    }

    private List<Record> recordRound(RacingCars racingCars) {
        List<Record> records = new ArrayList<>();

        for (Car car : racingCars.getCars()) {
            records.add(new Record(car));
        }

        return records;
    }

    private void viewWinner() {
        List<Car> cars = this.racingCars.getCars();
        ResultView.viewWinner(Ranking.findWinners(cars));
    }
}
