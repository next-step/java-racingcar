package racing.domain;

import racing.common.ErrorMessage;
import racing.common.RacingSettings;
import racing.common.RacingValidator;
import racing.common.RandomNumberGenerator;
import racing.vo.GameMakingInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingManager {
    private final static int START_TIME = 0;
    private final static int MAX_RANDOM_NUMBER = 9;
    private List<Cars> movingHistory;
    private Cars cars;
    private final int time;
    
    public RacingManager(final GameMakingInfo gameMakingInfo) {
        makeSureUserInputs(gameMakingInfo);
        this.cars = new Cars.Builder(makeCarsAt(gameMakingInfo.getCarNames()))
          .generator(new RandomNumberGenerator(MAX_RANDOM_NUMBER)).build();
        time = gameMakingInfo.getTime();
        movingHistory = new ArrayList<>();
    }
    
    private static List<Car> makeCarsAt(final String carNames) {
        return Arrays.stream(carNames.split(RacingSettings.CAR_NAME_SEPARATOR.getStr()))
                .map(Car::new)
                .collect(Collectors.toList());
    }
    
    private void makeSureUserInputs(final GameMakingInfo gameMakingInfo) {
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
    
    private static void throwException(final String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
