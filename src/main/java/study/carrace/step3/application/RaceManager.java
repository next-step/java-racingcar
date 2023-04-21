package study.carrace.step3.application;

import study.carrace.step3.domain.*;
import study.carrace.step3.domain.exception.IllegalIterationCountException;

import java.util.List;
import java.util.stream.IntStream;

public class RaceManager {
    private static final String LINE_BREAK = "\n";
    private final Cars cars;
    private final int iterationCount;

    public RaceManager(List<String> carNames, MoveStrategy moveStrategy, int iterationCount) {
        validateIterationCount(iterationCount);

        this.cars = new Cars(carNames, moveStrategy);
        this.iterationCount = iterationCount;
    }

    public void startRace() {
        IntStream.range(0, iterationCount)
                .forEach(iteration -> moveOrStopCars());
    }

    public String carsPositionHistory() {
        StringBuilder carsPositionHistory = new StringBuilder();
        IntStream.rangeClosed(1, iterationCount)
                .forEach(iteration -> carsPositionHistory.append(carsPositionAt(iteration)).append(LINE_BREAK));

        return carsPositionHistory.toString();
    }

    public List<CarName> winners() {
        return cars.firstRankers();
    }

    private String carsPositionAt(int iteration) {
        return cars.carsPositionAt(iteration);
    }

    private void moveOrStopCars() {
        cars.moveOrStopCars();
    }

    private void validateIterationCount(int iterationCount) {
        if (iterationCount <= 0) {
            throw new IllegalIterationCountException(iterationCount);
        }
    }
}
