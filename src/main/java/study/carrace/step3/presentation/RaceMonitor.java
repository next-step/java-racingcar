package study.carrace.step3.presentation;

import study.carrace.step3.domain.Car;
import study.carrace.step3.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

import static study.carrace.step3.presentation.PromptMessage.*;

public class RaceMonitor {
    private static final String LINE_BREAK = "\n";
    private static final char POSITION_CURSOR = '-';
    private final Cars cars;
    private final int iterationCount;

    public RaceMonitor(Cars cars, int iterationCount) {
        this.cars = cars;
        this.iterationCount = iterationCount;
    }

    public void showCarsPositionHistory() {
        announceRaceResult();
        IntStream.rangeClosed(1, iterationCount)
                .forEach(i -> System.out.println(carNamesAndPositionsAt(i)));
    }

    public String carNamesAndPositionsAt(int iteration) {
        StringBuilder carNamesAndPositions = new StringBuilder();
        cars.cars().forEach(car -> carNamesAndPositions
                .append(carNameAndPositionAt(car, iteration))
                .append(LINE_BREAK));

        return carNamesAndPositions.toString();
    }

    public String carNameAndPositionAt(Car car, int iteration) {
        return String.format("%s: %s", car.carName(), positionAt(car.moveStatusesAt(iteration)));
    }

    public String positionAt(List<Boolean> moveStatuses) {
        StringBuilder position = new StringBuilder();
        moveStatuses.stream()
                .filter(b -> b)
                .forEach(b -> position.append(POSITION_CURSOR));

        return position.toString();
    }

    public void announceWinners() {
        System.out.println(cars.firstRankers() + WINNER_ANNOUNCE_MESSAGE.getMessage());
    }

    private void announceRaceResult() {
        System.out.println(RACE_RESULT_ANNOUNCE_MESSAGE.getMessage());
    }
}
