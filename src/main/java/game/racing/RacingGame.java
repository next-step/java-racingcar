package game.racing;

import game.core.domain.Game;
import game.core.domain.ResultEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingGame implements Game<RacingResult> {

    private List<Car> cars;
    private int numberOfRound;
    private RacingResult result;

    public RacingGame(String[] carNames, int numberOfRound) {
        result = new RacingResult();
        this.cars = createCars(carNames);
        this.numberOfRound = numberOfRound;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfRound; i++) {
            cars.parallelStream().forEach(Car::move);
        }
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
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
