package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private final MoveStrategy moveStrategy;
    private final Cars cars;
    private final RunCount runCount;

    public CarRace(List<String> carNames, int count) {
        this(carNames, count, new MoveStrategy());
    }

    public CarRace(List<String> carNames, int count, MoveStrategy moveStrategy) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.cars = new Cars(carList);
        this.runCount = new RunCount(count);
        this.moveStrategy = moveStrategy;
    }

    public List<List<CarState>> run() {
        return runCount.intStream()
                .mapToObj(i -> runOnce())
                .collect(Collectors.toList());
    }

    private List<CarState> runOnce() {
        runCount.decrease();
        return cars.moveAll(moveStrategy);
    }

    public List<CarState> findWinners() {
        if (runCount.isRemaining())
            throw new UnsupportedOperationException("car race is still running.");

        return cars.findWinners();
    }

    public int getRemainRunCount() {
        return runCount.get();
    }

}

