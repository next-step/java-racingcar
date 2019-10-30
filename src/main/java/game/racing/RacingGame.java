package game.racing;

import game.Game;
import game.ResultEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingGame implements Game<RacingResult> {

    private String[] carNames;
    private int numberOfTimes;
    private RacingResult result;

    public RacingGame(RacingGameSettings settings) {
        carNames = settings.getCarNames();
        numberOfTimes = settings.getNumberOfTimes();
        result = new RacingResult();
    }

    @Override
    public void run() {
        List<Car> cars = createCars();
        for (int i = 0; i < numberOfTimes; i++) {
            cars.parallelStream().forEach(Car::move);
        }
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        int numberOfCar = carNames.length;
        for (int i = 0; i < numberOfCar; i++) {
            String name = carNames[i];
            TrackingLog trackingLog = result.register(name);
            cars.add(new DefaultCar(name, trackingLog));
        }
        return cars;
    }

    @Override
    public ResultEntity<RacingResult> getResultEntity() {
        return new ResultEntity<>(result);
    }
}
