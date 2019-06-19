package racing.domain;

import static racing.common.RacingSettings.*;

import racing.common.ErrorMessage;
import racing.common.RacingSettings;
import racing.common.RacingValidator;
import racing.common.RandomNumberGenerator;
import racing.vo.GameMakingInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingManager {
    private final static int START_TIME = 0;
    private List<Cars> movingHistory;
    private Cars cars;
    private int time;
    
    public RacingManager(GameMakingInfo gameMakingInfo) {
        makeSureUserInputs(gameMakingInfo);
        this.cars = new Cars(Arrays.stream(gameMakingInfo.getCarNames().split(RacingSettings.CAR_NAME_SEPARATOR.getStr()))
            .map(Car::new)
            .collect(Collectors.toList())
        );
        time = gameMakingInfo.getTime();
        movingHistory = new ArrayList<>();
    }
    
    private void makeSureUserInputs(GameMakingInfo gameMakingInfo) {
        if (!RacingValidator.isValidCarNames(gameMakingInfo.getCarNames())) {
            throwException(ErrorMessage.INCORRECT_CAR_NAMES.getMessage());
        }
        if (!RacingValidator.isInTimeRange(gameMakingInfo.getTime())) {
            throwException(ErrorMessage.INCORRECT_TIME.getMessage());
        }
    }
    
    public String getWinnerNames() {
        return cars.getWinner().getCarNames();
    }
    
    public void startGame() {
        IntStream.range(START_TIME, time).forEach(i -> {
            cars.moveCars();
            movingHistory.add(cars.getCopiedCars());
        });
    }
    
    public List<Cars> getMovingHistory() {
        return movingHistory;
    }
    
    public void setCars(Cars cars) {
        this.cars = cars;
    }
    
    private static void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
