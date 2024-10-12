package racingcar;


import racingcar.domain.*;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class GameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int tryCount = inputView.getTryCount();
        RaceGame raceGame = new RaceGame(carNames,tryCount);

        run(raceGame);
    }

    private static void run(final RaceGame game) {
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        List<Records> positions = game.playGame(moveStrategy);
        ResultView.printGameResult(positions);


        Winner winner = new Winner(positions.get(positions.size() - 1));
        ResultView.printWinners(winner);
    }
}
