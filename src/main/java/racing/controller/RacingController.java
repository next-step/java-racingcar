package racing.controller;

import racing.common.ErrorMessage;
import racing.common.RacingValidator;
import racing.domain.RacingManager;
import racing.view.RacingView;
import racing.vo.GameMakingInfo;

public class RacingController {
    private RacingView racingView;
    private RacingManager racingManager;
    
    public RacingController(RacingView view) {
        this.racingView = view;
        racingView.setController(this);
        makeNewGame(racingView.requestGameInfo());
    }     
    
    public RacingManager makeNewGame(final GameMakingInfo gameMakingInfo) {
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
        racingView.printMovingStatus(racingManager.getMovingHistory());
        racingView.printWinner(racingManager.getWinnerNames());
    }
    
    private static void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
