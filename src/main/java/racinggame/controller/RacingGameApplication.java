package racinggame.controller;

import racinggame.domain.UserInput;
import racinggame.domain.racing.Racing;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readUserInput();

        UserInput userInput = new UserInput(inputView.getCarNames(), inputView.getGameCount());

        Racing racing = new Racing(userInput.getCarNames(), userInput.getGameCount());
        racing.playAllRound();

        ResultView resultView = new ResultView();
        resultView.drawResult(racing.getRoundResult(), racing);
    }
}
