package study.carrace.step3.application;

import study.carrace.step3.application.dto.RaceFinishedCar;
import study.carrace.step3.domain.*;
import study.carrace.step3.domain.exception.IllegalIterationCountException;

import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private final int iterationCount;
    private final Cars cars;

    public RaceManager(List<String> carNames, MoveStrategy moveStrategy, int iterationCount) {
        validateIterationCount(iterationCount);

        this.cars = new Cars(carNames, moveStrategy);
        this.iterationCount = iterationCount;
    }

    public List<RaceFinishedCar> startRace() {
        return cars.moveOrStopCars(iterationCount)
                .cars()
                .stream()
                .map(this::of)
                .collect(Collectors.toList());
    }

    private RaceFinishedCar of(Car car) {
        return new RaceFinishedCar(car.carName().name(), car.carPosition().moveStatuses());
    }

    private void validateIterationCount(int iterationCount) {
        if (iterationCount <= 0) {
            throw new IllegalIterationCountException(iterationCount);
        }
    }
}
