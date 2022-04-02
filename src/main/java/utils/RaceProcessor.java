package utils;

import core.Car;
import core.Cars;

import java.util.List;
import java.util.Random;

public class RaceProcessor {
    public static Cars createValidCars() {
        Cars cars = createInitialCarsFromInput();

        while (Boolean.FALSE.equals(cars.isValid())) {
            cars = recreateInvalidCars();
        }
        return cars;
    }

    public static int determineMoveCountFromInput() {
        AnnouncementPrinter.printMoveCountInputAnnouncement();
        return CustomScanner.scanMoveCount();
    }

    public static void moveCarsRandomlyMoveCountTimes(Cars cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            RaceProcessor.moveCarsRandomly(cars);
        }
    }

    private static void moveCarsRandomly(Cars cars) {
        for (Car car : cars.getCars()) {
            Random random = new Random();
            car.move(random.nextInt(Car.MAX_MOVE_VALUE));
        }
    }

    private static Cars recreateInvalidCars() {
        Cars cars;
        List<String> carNames;
        AnnouncementPrinter.printCarNameInvalidAnnouncement();
        carNames = scanNullSafeCarNames();
        cars = Cars.fromCarNames(carNames);
        return cars;
    }

    private static Cars createInitialCarsFromInput() {
        AnnouncementPrinter.printCarNameInputAnnouncement();
        List<String> carNames = scanNullSafeCarNames();
        return Cars.fromCarNames(carNames);
    }

    private static List<String> scanNullSafeCarNames() {
        List<String> carNames = CustomScanner.scanInputCarNames();
        while (carNames.isEmpty()) {
            AnnouncementPrinter.printEmptyCarNameInputAnnouncement();
            carNames = CustomScanner.scanInputCarNames();
        }
        return carNames;
    }
}
