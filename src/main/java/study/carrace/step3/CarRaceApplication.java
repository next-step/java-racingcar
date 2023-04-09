package study.carrace.step3;

import study.carrace.step3.domain.Car;
import study.carrace.step3.domain.RandomZeroAndPositiveIntegerGenerator;
import study.carrace.step3.presentation.RaceMonitor;

import java.util.ArrayList;
import java.util.List;

import static study.carrace.step3.presentation.util.ConsoleInputUtil.*;

public class CarRaceApplication {
    private static final int MOVABLE_THRESHOLD = 4;
    private static final int MAX_RANDOM_INTEGER = 9;

    public static void main(String[] args) {
        List<Car> cars = createCars(askCarQuantity());
        RaceMonitor raceMonitor = new RaceMonitor(cars);

        startRace(raceMonitor, cars, askIterationCount());
    }

    private static void startRace(RaceMonitor raceMonitor, List<Car> cars, int iterationCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < iterationCount; i++) {
            moveCars(cars);
            raceMonitor.showCarsPosition();
            System.out.println("");
        }
    }

    private static void moveCars(List<Car> cars) {
        cars.forEach(car -> car.moveOrStop());
    }

    private static List<Car> createCars(int carQuantity) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carQuantity; i++) {
            cars.add(createCar());
        }

        return cars;
    }

    private static Car createCar() {
        return new Car(new RandomZeroAndPositiveIntegerGenerator(MAX_RANDOM_INTEGER), MOVABLE_THRESHOLD);
    }
}
