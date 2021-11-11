package racinggame;

import racinggame.utils.GameExecutorFactory;
import racinggame.utils.WinnerChooser;
import racinggame.view.InputView;
import racinggame.view.ResultView;
import racinggame.vo.MoveResult;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.carNames();
        String numberOfAttempts = inputView.numberOfAttempts();

        GameExecutor gameExecutor = GameExecutorFactory.createGameExecutor(carNames, numberOfAttempts);

        List<MoveResult> results = gameExecutor.execute();

        ResultView resultView = new ResultView(results, WinnerChooser.chooseWinner(results));
        resultView.showResult();
    }
}
