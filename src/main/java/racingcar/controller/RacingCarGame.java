package racingcar.controller;

import racingcar.domain.*;
import racingcar.rule.Rule;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGame {
    private final ResultView resultView;
    private final InputView inputView;

    private final Rule rule;

    public RacingCarGame(InputView inputView, ResultView resultView, Rule rule) {
        this.inputView = inputView;
        this.resultView = resultView;

        this.rule = rule;
    }

    public void start() {
        List<String> carNames = inputView.readCar();
        int raceCount = inputView.readRace();

        Cars cars = Cars.ofString(carNames);
        Races races = cars.races(rule, raceCount);

        for (Race race : races.getRaces()) {
            printRaceRecord(race.start());
        }
        printWinners(races.winners());
    }

    private void printRaceRecord(RaceRecords raceRecords) {
        resultView.printRaceRecords(raceRecords);
    }

    private void printWinners(List<CarName> winners) {
        resultView.printWinner(winners);
    }
}
