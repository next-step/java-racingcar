package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void execute() {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.getName());
        Race race = new Race(cars, inputView.getTimes());
        OutputView.printHistories(race.playGames());
        Winner winner = new Winner(race.getFinalResult());
        winner.setWinners();
        OutputView.printWinners(winner.getWinners());
    }
}
