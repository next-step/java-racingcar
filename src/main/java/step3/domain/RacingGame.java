package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int carCount;
    private final int tryCount;
    private final ProceedPolicy proceedPolicy;
    private final RacingHistories histories = new RacingHistories();

    public RacingGame(int carCount, int tryCount, ProceedPolicy proceedPolicy) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        this.proceedPolicy = proceedPolicy;
    }

    public void run() {
        Cars cars = createCars();
        histories.add(cars);

        for (int i = 0; i < tryCount; ++i) {
            cars.proceedWithPolicy(proceedPolicy);
            histories.add(cars);
        }
    }

    protected Cars createCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; ++i) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public List<String> getRacingHistory() {
        return histories.getHistories();
    }
}
