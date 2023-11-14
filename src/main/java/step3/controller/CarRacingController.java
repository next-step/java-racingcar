package step3.controller;

import step3.domain.GameResult;
import step3.service.RacingCarService;
import step3.view.OutputView;

public class CarRacingController {

    public static void startGame(int carCount, int roundCount){
        GameResult resultBoard = RacingCarService.playRound(carCount, roundCount);
        OutputView.printResultStatement();
        OutputView.drawResultView(resultBoard.showResult());
    }
}
