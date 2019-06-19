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
        makeSureUserInputs(gameMakingInfo);
        racingManager = new RacingManager(gameMakingInfo);
        return racingManager;
    }
            
    private void makeSureUserInputs(final GameMakingInfo gameMakingInfo) {
        if (!RacingValidator.isValidCarNames(gameMakingInfo.getCarNames())) {
            throwException(ErrorMessage.INCORRECT_CAR_NAMES.getMessage());
        }
        if (!RacingValidator.isInTimeRange(gameMakingInfo.getTime())) {
            throwException(ErrorMessage.INCORRECT_TIME.getMessage());
        }
    }
    
    public void processGame() {
        racingManager.startGame();
        resultView.printMovingStatus(racingManager.getMovingHistory());
        resultView.printWinners(racingManager.getWinnerNames());
    }
    
    private static void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
