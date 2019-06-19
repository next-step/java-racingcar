package racing.domain;

import static racing.common.RacingSettings.*;

import racing.common.RacingSettings;
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
    private final static int MAX_RANDOM_MOVABLE_NUMBER = 9;
    private final static int START_TIME = 0;
    private List<Cars> movingHistory;
    private RandomNumberGenerator randomGenerator;
    private Cars cars;
    private int time;
    
    public RacingManager(final GameMakingInfo gameMakingInfo) {
        this.cars = new Cars(Arrays.stream(gameMakingInfo.getCarNames().split(RacingSettings.CAR_NAME_SEPARATOR.getStr()))
            .map(Car::new)
            .collect(Collectors.toList())
        );
        time = gameMakingInfo.getTime();
        randomGenerator = new RandomNumberGenerator(MAX_RANDOM_MOVABLE_NUMBER);
        movingHistory = new ArrayList<>();
        movingHistory.add(cars);
    }
    
    public String getWinnerNames() {
        return cars.getWinner().getCarNames();
    }
    
    public void startGame() {
        IntStream.range(START_TIME, time)
            .forEach(i -> cars.moveCars(randomGenerator.getNumber()));
        movingHistory.add(cars.getCopiedCars());
    }
    
    public List<Cars> getMovingHistory() {
        return movingHistory;
    }
    
    public Cars getCars() {
        return cars;
    }
    
    public void setCars(Cars cars) {
        this.cars = cars;
    }
}
