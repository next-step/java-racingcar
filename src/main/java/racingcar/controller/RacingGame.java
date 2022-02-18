package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.Times;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private RacingGame() {
    }

    public static void execute() {
        Race race = new Race(InputView.inputName());
        Times times = new Times(InputView.inputTimes());
        race.repeatGame(times.getTimes());
        OutputView.printWinners(race);
    }
}
