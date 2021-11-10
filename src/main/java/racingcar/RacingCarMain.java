package racingcar;

import racingcar.dto.GameConfigDto;
import racingcar.dto.GameResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        GameConfigDto gameConfigDto = inputView.initConfig();
        GameStage gameStage = GameStage.init(gameConfigDto);
        GameResult result = gameStage.start();

        ResultView resultView = new ResultView();
        resultView.show(result);
    }

}
