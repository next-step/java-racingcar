package racingcar;

import java.util.List;

import racingcar.domain.Game;
import racingcar.domain.RacingGame;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int round = inputView.getRound();
        Game game = new RacingGame(carNames);
        ResultView resultView = new ResultView();
        for (int i = 0; i < round; i++) {
            game.start();
            resultView.printResult(game.getVehicles());
        }
        resultView.printWinners(game.getWinners());
    }

}
