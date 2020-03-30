package racinggame.controller;

import racinggame.domain.racing.Racing;
import racinggame.util.StringUtil;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameApplication {

    private static final String CAR_NAME_DELIMITER = ",";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readUserInput();

        Racing racing = new Racing(
                StringUtil.splitString(inputView.getCarNames(), CAR_NAME_DELIMITER),
                inputView.getGameCount());
        racing.playAllRound();

        ResultView resultView = new ResultView();
        resultView.drawResult(racing.getRacingRoundResults(), racing);
    }
}
