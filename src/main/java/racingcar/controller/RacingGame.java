package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private RacingGame() {
    }

    public static void execute() {
        Race race = new Race(InputView.inputName());
        int times = InputView.inputTimes();
        race.repeatGame(times);
        OutputView.printWinners(race);
    }

}
