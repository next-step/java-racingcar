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
    private final static int START_TIME = 0;
    private List<Cars> movingHistory;
    private Cars cars;
    private int time;
    
    public RacingManager(GameMakingInfo gameMakingInfo) {
        this.cars = new Cars(Arrays.stream(gameMakingInfo.getCarNames().split(RacingSettings.CAR_NAME_SEPARATOR.getStr()))
            .map(Car::new)
            .collect(Collectors.toList())
        );
        time = gameMakingInfo.getTime();
        movingHistory = new ArrayList<>();
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
}
