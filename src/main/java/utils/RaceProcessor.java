package utils;

import core.Car;
import core.Cars;

import java.util.List;
import java.util.Random;

public class RaceProcessor {
    public static Cars createValidCars() {
        try {
            return createCarsFromInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createValidCars();
        }
    }

    public static int determineMoveCountFromInput() {
        AnnouncementPrinter.printMoveCountInputAnnouncement();
        return CustomScanner.scanMoveCount();
    }

    public static Cars moveCarsRandomlyMoveCountTimes(Cars cars, int moveCount) {
        Cars resultCars = cars;
        for (int i = 0; i < moveCount; i++) {
            resultCars = RaceProcessor.moveCarsRandomly(resultCars);
        }
        return resultCars;
    }

    private static Cars moveCarsRandomly(Cars cars) {
        Random random = new Random();
        return cars.moveCarsRandomly(random);
    }

    private static Cars createCarsFromInput() {
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
