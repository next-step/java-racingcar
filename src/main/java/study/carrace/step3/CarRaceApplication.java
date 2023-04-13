package study.carrace.step3;

import study.carrace.step3.domain.*;
import study.carrace.step3.presentation.RaceMonitor;

import java.util.List;
import java.util.stream.Collectors;

import static study.carrace.step3.presentation.util.ConsoleInputUtil.*;

public class CarRaceApplication {
    private static final int MOVABLE_THRESHOLD = 4;
    private static final int MAX_RANDOM_INTEGER = 9;

    public static void main(String[] args) {
        List<Car> cars = cars(askCarNames());
        RaceMonitor raceMonitor = new RaceMonitor(cars);

        startRace(raceMonitor, cars, askIterationCount());
        announceWinners(raceMonitor);
    }

    private static void announceWinners(RaceMonitor raceMonitor) {
        raceMonitor.announceWinners();
    }

    private static void startRace(RaceMonitor raceMonitor, List<Car> cars, long iterationCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < iterationCount; i++) {
            moveCars(cars);
            raceMonitor.showCarsPosition();
        }
    }

    private static void moveCars(List<Car> cars) {
        cars.forEach(car -> car.moveOrStop());
    }

    private static List<Car> cars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, randomMoveStrategy()))
                .collect(Collectors.toList());
    }

    private static MoveStrategy randomMoveStrategy() {
        return new RandomMoveStrategy(randomIntegerGenerator(), MOVABLE_THRESHOLD);
    }

    private static RandomIntegerGenerator randomIntegerGenerator() {
        return new RandomZeroAndPositiveIntegerGenerator(MAX_RANDOM_INTEGER);
    }
}
