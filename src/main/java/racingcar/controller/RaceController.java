package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Movable;
import racingcar.domain.Race;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private static final int MOVE_THRESHOLD = 4;

    public void execute() {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.getName());
        Race race = new Race(cars, inputView.getTimes());
        Movable movable = () -> race.getRandomNumber() >= MOVE_THRESHOLD;
        OutputView.printHistories(race.playGames(movable));
        Winner winner = new Winner(race.getFinalResult());
        winner.setWinners();
        OutputView.printWinners(winner.getWinners());
    }
}
