package racing.controller;

import racing.common.ErrorMessage;
import racing.common.RacingValidator;
import racing.domain.RacingManager;
import racing.view.InputView;
import racing.view.ResultView;
import racing.vo.GameMakingInfo;

public class RacingController {
    private ResultView resultView;
    private RacingManager racingManager;
    
    public RacingController(InputView inputView, ResultView resultView) {
        this.resultView = resultView;
        makeNewGame(inputView.requestGameInfo());
    }     
    
    public RacingManager makeNewGame(GameMakingInfo gameMakingInfo) {
        racingManager = new RacingManager(gameMakingInfo);
        return racingManager;
    }
    
    public void processGame() {
        racingManager.startGame();
        resultView.printMovingStatus(racingManager.getMovingHistory());
        resultView.printWinners(racingManager.getWinnerNames());
    }
}
