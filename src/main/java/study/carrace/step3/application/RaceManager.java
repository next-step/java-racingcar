package study.carrace.step3.application;

import study.carrace.step3.domain.*;
import study.carrace.step3.domain.exception.IllegalIterationCountException;

import java.util.List;

public class RaceManager {
    private final int iterationCount;
    private final Cars cars;

    public RaceManager(List<String> carNames, MoveStrategy moveStrategy, int iterationCount) {
        validateIterationCount(iterationCount);

        this.cars = new Cars(carNames, moveStrategy);
        this.iterationCount = iterationCount;
    }

    public Cars startRace() {
        return cars.moveOrStopCars(iterationCount);
    }

    public List<CarName> winners() {
        return cars.firstRankers();
    }

    private void validateIterationCount(int iterationCount) {
        if (iterationCount <= 0) {
            throw new IllegalIterationCountException(iterationCount);
        }
    }
}
