package racing;

import racing.common.ErrorMessage;
import racing.common.RacingGame;
import racing.common.RacingValidator;
import racing.view.RacingView;

public class RacingController {
    private RacingView racingView;
    public RacingController(RacingView racingView) {
        this.racingView = racingView;
    }
    
    public RacingGame makeNewGame(String carNames, int time) {
        if (isValidCarNames(carNames)) {
            throwException(ErrorMessage.INCORRECT_TIME.getMessage());
        }
        
        if (isValidTime(time)) {
            throwException(ErrorMessage.INCORRECT_TIME.getMessage());
        }

        return new RacingGame(carNames, time);
    }
    
    private static boolean isValidCarNames(String carNames) {
        return RacingValidator.isValidCarNames(carNames);
    }
    
    private static boolean isValidTime(int time) {
        return RacingValidator.isInTimeCountRange(time);
    }
    
    private static void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
