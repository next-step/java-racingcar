package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void execute() {
        InputView inputView = new InputView();
        Race race = new Race(inputView.getName(), inputView.getTimes());
        race.playGames();
        Winner winner = new Winner(race.getFinalResult());
        winner.setWinners();
        OutputView.printWinners(winner.getWinners());
    }
}
