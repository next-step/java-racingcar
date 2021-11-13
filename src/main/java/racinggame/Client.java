package racinggame;

import racinggame.utils.GameExecutorFactory;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Client {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.carNames();
        String numberOfAttempts = inputView.numberOfAttempts();

        SimpleGameExecutor gameExecutor = GameExecutorFactory.createGameExecutor(carNames, numberOfAttempts);

        RacingResult result = gameExecutor.execute();

        ResultView resultView = new ResultView(result);
        resultView.showResult();
    }
}
