package racing.controller;

import racing.common.RacingSettings;
import racing.domain.RacingManager;
import racing.common.ErrorMessage;
import racing.common.RacingValidator;
import racing.view.RacingView;
import racing.vo.Car;
import racing.vo.Cars;
import racing.vo.GameMakingInfo;

import java.util.stream.IntStream;

public class RacingController {
    private RacingView racingView;
    private RacingManager racingManager;
    private int time;
    
    public RacingController(RacingView view) {
        this.racingView = view;
        racingView.setController(this);
        racingView.requestGameInfo();
    }     
    
    public RacingManager makeNewGame(final GameMakingInfo gameMakingInfo) {
        makeSureUserInputs(gameMakingInfo);
        racingManager = new RacingManager(gameMakingInfo.getCarNames());
        this.time = gameMakingInfo.getTime();
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
        processCarMoving();
        Cars winners = racingManager.getWinners();
        String carNames = winners.getCars().stream()
            .map(Car::getName)
            .reduce((name1, name2) -> name1 += RacingSettings.CAR_NAME_SEPARATOR.getStr() + name2)
            .get();
        racingView.printWinner(carNames);
    }
    
    private void processCarMoving() {
        IntStream.range(RacingSettings.MOVING_START_COUNT.getValue(), time)
            .forEach(i -> { 
                racingManager.moveCars();
                racingView.printMovingStatus(racingManager.getCars()); 
            });
    }
    
    private static void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
