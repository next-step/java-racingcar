package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return new Cars(carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public RacingHistories getRacingHistories() {
        return histories;
    }
}
