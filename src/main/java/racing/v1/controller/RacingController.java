package racing.v1.controller;

import racing.v1.service.RacingService;
import racing.v1.view.InputView;
import racing.v1.view.ResultView;

public class RacingController {
    public void run(){
        RacingService racingService = new RacingService();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        racingService.setCarCount(inputView.getCarCount());
        racingService.setMoveCount(inputView.getMoveCount());

        racingService.showResult(resultView);
    }
}
