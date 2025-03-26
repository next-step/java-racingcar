package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private final MoveStrategy moveStrategy;
    private final Cars cars;
    private final RunCount runCount;

    public CarRace(Cars cars, RunCount runCount, MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.cars = cars;
        this.runCount = runCount;
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
        if(runCount.isRemaining())
            throw new UnsupportedOperationException("car race is still running.");

        return cars.findWinners();
    }

}

