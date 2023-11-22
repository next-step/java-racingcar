package step4.controller;

import step4.domain.GameResult;
import step4.service.RacingCarService;
import step4.view.OutputView;

public class CarRacingController {
    public static void startGame(String nameString, int roundCount) {
        GameResult result = RacingCarService.playGame(nameString, roundCount);
        OutputView.printResultStatement();
        OutputView.drawResultView(result);
        OutputView.printWinner(result.winnerList().winners());
    }

}
