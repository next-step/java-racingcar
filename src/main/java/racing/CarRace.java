package racing;

import java.util.List;
import java.util.function.Consumer;

public class CarRace {
    private static final CarMovingStrategy DEFAULT_STRATEGY = new RandomCarMovingStrategy();

    private final Cars cars;
    private final TrialNum trialNumber;

    public CarRace(String[] carNames, int trialNumber) {
        this.cars = new Cars(carNames);
        this.trialNumber = new TrialNum(trialNumber);
    }

    public void startRace(Consumer<Cars> callback) {
        startRace(DEFAULT_STRATEGY, callback);
    }

    public void startRace(CarMovingStrategy strategy, Consumer<Cars> callback) {
        for (int i = 0; i < trialNumber.getValue(); i++) {
            cars.move(strategy);
            callback.accept(cars);
        }
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
