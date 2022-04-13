package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private final ProceedPolicy proceedPolicy;
    private final RacingHistories histories = new RacingHistories();

    public RacingGame(List<String> carNames, ProceedPolicy proceedPolicy) {
        this.cars = createCars(carNames);
        this.proceedPolicy = proceedPolicy;
    }

    public void run(int tryCount) {
        histories.add(cars);

        for (int i = 0; i < tryCount; ++i) {
            cars.proceedWithPolicy(proceedPolicy);
            histories.add(cars);
        }
    }

    private Cars createCars(List<String> carNames) throws IllegalArgumentException {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public RacingHistories getRacingHistories() {
        return histories;
    }
}
