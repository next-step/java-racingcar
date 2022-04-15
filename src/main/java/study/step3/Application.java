package study.step3;

import study.step3.service.RacingGameService;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        GameConfig gameConfig = new GameConfig(inputView.gameCount(), inputView.carCount());
        RacingGame racingGame = new RacingGame(gameConfig.getCars());
        RacingGameService racingGameService = new RacingGameService(gameConfig, racingGame);

        ResultView resultView = new ResultView(racingGameService);

    }
}
