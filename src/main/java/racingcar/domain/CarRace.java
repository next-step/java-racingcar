package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {
    private final MoveStrategy moveStrategy;
    private final Cars cars;
    private int runCount;

    public CarRace(Cars cars, int runCount, MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.cars = cars;
        this.runCount = runCount;
    }

    public List<List<CarState>> run() {
        return IntStream.range(0, runCount)
                .mapToObj(i -> runOnce())
                .collect(Collectors.toList());
    }

    private List<CarState> runOnce() {
        runCount--;
        return cars.move(moveStrategy);
    }

    public List<CarState> findWinners() {
        if(runCount > 0)
            throw new UnsupportedOperationException("car race is still running.");

        return cars.findWinners();
    }
}

