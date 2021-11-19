package racingcar;

import racingcar.domain.GameConfig;
import racingcar.domain.GameResult;
import racingcar.domain.GameStage;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        GameConfig gameConfig = inputView.initConfig();
        GameStage gameStage = GameStage.init(gameConfig);
        GameResult result = gameStage.start();

        ResultView resultView = new ResultView();
        resultView.show(result);
    }

}
