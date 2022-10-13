package racing;

import java.util.List;
import java.util.function.Consumer;

public class CarRace {
    private static final CarMovingStrategy DEFAULT_STRATEGY = new RandomCarMovingStrategy();

    private final Cars cars;
    private final int numberOfTrials;

    public CarRace(String[] carNames, int numberOfTrials) {
        this.cars = new Cars(carNames);
        this.numberOfTrials = numberOfTrials;
    }

    public void startRace(Consumer<Cars> callback) {
        startRace(DEFAULT_STRATEGY, callback);
    }

    public void startRace(CarMovingStrategy strategy, Consumer<Cars> callback) {
        for (int i = 0; i < numberOfTrials; i++) {
            cars.move(strategy);
            callback.accept(cars);
        }
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
