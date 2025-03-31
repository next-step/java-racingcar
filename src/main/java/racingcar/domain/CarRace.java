package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private final MoveStrategy moveStrategy;
    private final Cars cars;
    private final RunCount runCount;

    public CarRace(List<String> carNames, int count) {
        this(carNames, count, new MoveStrategy());
    }

    public CarRace(List<String> carNames, int count, MoveStrategy moveStrategy) {
        this.cars = Cars.from(carNames);
        this.runCount = new RunCount(count);
        this.moveStrategy = moveStrategy;
    }

    public List<List<CarDto>> run() {
        List<List<CarDto>> results = new ArrayList<>();
        while (runCount.isRemaining()) {
            results.add(runOnce());
        }
        return results;
    }

    private List<CarDto> runOnce() {
        runCount.decrease();
        return cars.moveAll(moveStrategy);
    }

    public List<CarDto> findWinners() {
        if (runCount.isRemaining())
            throw new UnsupportedOperationException("car race is still running.");

        return cars.findWinners();
    }

}

