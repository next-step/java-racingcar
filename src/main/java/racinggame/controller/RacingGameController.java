package racinggame.controller;

import racinggame.domain.value.RacingResult;
import racinggame.service.SimpleGameExecutor;
import racinggame.utils.GameExecutorFactory;
import racinggame.view.ResultView;

public class RacingGameController {

    public void startGame(String carNames, String numberOfAttempts) {
        SimpleGameExecutor gameExecutor = GameExecutorFactory.createGameExecutor(carNames, numberOfAttempts);

        RacingResult result = gameExecutor.execute();

        ResultView resultView = new ResultView(result);
        resultView.showResult();
    }
}
