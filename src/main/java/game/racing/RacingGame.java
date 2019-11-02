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

    private List<Car> cars;
    private int numberOfRounds;
    private RacingResult result;

    public RacingGame(RacingInputView inputView) {
        result = new RacingResult();
        cars = createCars(inputView.getCarNames());
        this.numberOfRounds = inputView.getNumberOfRounds();
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfRounds; i++) {
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
