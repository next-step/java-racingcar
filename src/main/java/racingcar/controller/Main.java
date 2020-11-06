package racingcar.controller;

import racingcar.domain.aggregate.RacingGame;
import racingcar.domain.collection.History;
import racingcar.domain.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        String nameCsv = inputView.askNames();
        int maxRaceNum = inputView.askMaxRaceNum();

        RacingGame game = new RacingGame(nameCsv, maxRaceNum);
        game.play();

        OutputView outputView = OutputView.getInstance();
        outputView.printResultMsg();

        History history = game.getHistory();
        outputView.printHistory(history);

        List<Car> winners = game.getWinners();
        outputView.printWinners(winners);
    }
}
