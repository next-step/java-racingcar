package racingcar;

import racingcar.dto.GameConfig;
import racingcar.dto.GameResult;
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
