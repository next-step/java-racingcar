package racing.controller;

import racing.domain.RacingManager;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {
    private final ResultView resultView;
    private RacingManager racingManager;
    
    public RacingController(final InputView inputView, final ResultView resultView) {
        this.resultView = resultView;
        racingManager = new RacingManager(inputView.requestGameInfo());
    }
    
    public void processGame() {
        resultView.printResult(racingManager.startGame());
    }
}
