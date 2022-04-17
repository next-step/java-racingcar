package step3;

import step3.model.Count;
import step3.model.GameResult;
import step3.model.RacingGame;
import step3.model.TryStrategy;
import step3.view.InputView;
import step3.view.ResultView;
import step3.view.dto.RacingConfigDto;

public class RacingGameApp {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        RacingConfigDto racingConfigDto = inputView.requestStart();

        Count tryCount = racingConfigDto.getTryCount();
        Count carCount = racingConfigDto.getCarCount();
        TryStrategy tryStrategy = racingConfigDto.getTryStrategy();

        RacingGame racingGame = new RacingGame(tryCount, carCount, tryStrategy);
        GameResult gameResult = racingGame.race();

        ResultView resultView = new ResultView();
        resultView.printResult(gameResult);
    }
}
