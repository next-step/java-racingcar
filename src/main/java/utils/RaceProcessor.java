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

    public static void moveCarsRandomly(Cars cars, int moveCount) {
        AnnouncementPrinter.printMoveResultAnnouncement();
        for (int i = 0; i < moveCount; i++) {
            RaceProcessor.moveCarsRandomly(cars);
        }
    }

    public static int determineMoveCountFromInput() {
        AnnouncementPrinter.printMoveCountInputAnnouncement();
        return CustomScanner.scanMoveCount();
    }

    private static void moveCarsRandomly(Cars cars) {
        for (Car car : cars.getCars()) {
            Random random = new Random();
            car.move(random.nextInt(Car.MAX_MOVE_VALUE));
        }
        AnnouncementPrinter.printCarsPosition(cars);
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
