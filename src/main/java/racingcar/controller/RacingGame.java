package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    public static void execute() {
        OutputView outputView = new OutputView();
        Race race = new Race(InputView.inputName());
        int times = InputView.inputTimes();
        race.repeatGame(times);
        outputView.printWinners(race);
    }

}
