package racing.controller;

import racing.common.RacingSettings;
import racing.logic.RacingManager;
import racing.common.ErrorMessage;
import racing.common.RacingValidator;
import racing.view.RacingView;
import racing.vo.Car;
import racing.vo.Cars;

import java.util.stream.IntStream;

public class RacingController {
    private RacingView racingView;
    private RacingManager racingManager;
    private int time;
    
    public RacingController(RacingView racingView) {
        this.racingView = racingView;
    }     
    
    public RacingManager makeNewGame(String carNames, int time) {
        if (!RacingValidator.isValidCarNames(carNames)) {
            throwException(ErrorMessage.INCORRECT_CAR_NAMES.getMessage());
        }
        if (!RacingValidator.isInTimeRange(time)) {
            throwException(ErrorMessage.INCORRECT_TIME.getMessage());
        }
        racingManager = new RacingManager(carNames);
        this.time = time;
        return racingManager;
    }
    
    public void processGame() {
        processCarMoving();
        Cars winners = racingManager.getWinners();
        String carNames = winners.getCars().stream()
            .map(Car::getName)
            .reduce((name1, name2) -> name1 += "," + name2)
            .get();
        racingView.printWinner(carNames);
    }
    
    private void processCarMoving() {
        IntStream.range(RacingSettings.MOVING_START_COUNT.getValue(), time).forEach(i -> {
            racingManager.moveCars();
            racingView.printMovingStatus(racingManager.getCars());
        });
    }
    
    private static void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
