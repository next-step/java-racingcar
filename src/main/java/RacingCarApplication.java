import core.Cars;
import core.Winners;
import utils.AnnouncementPrinter;
import utils.CustomScanner;

import java.util.List;
import java.util.Random;

public class RacingCarApplication {
    public static void main(String[] args) {
        Cars cars = createValidCars();
        int moveCount = determineMoveCountFromInput();
        AnnouncementPrinter.printMoveResultAnnouncement();
        for (int i = 0; i < moveCount; i++) {
            moveCarsRandomly(cars);
        }
        announceWinners(cars);
    }

    private static void announceWinners(Cars cars) {
        Winners winners = Winners.decideWinners(cars);
        winners.printWinners();
    }

    private static Cars createValidCars() {
        Cars cars = createInitialCarsFromInput();

        while (Boolean.FALSE.equals(cars.isValid())) {
            cars = recreateInvalidCars();
        }
        return cars;
    }

    private static void moveCarsRandomly(Cars cars) {
        cars.moveRandom(new Random());
        cars.printPositions();
        System.out.println();
    }

    private static int determineMoveCountFromInput() {
        AnnouncementPrinter.printMoveCountInputAnnouncement();
        return CustomScanner.scanMoveCount();
    }

    private static Cars recreateInvalidCars() {
        Cars cars;
        List<String> carNames;
        AnnouncementPrinter.printCarNameInvalidAnnouncement();
        carNames = scanNullSafeCarNames();
        cars = Cars.of(carNames);
        return cars;
    }

    private static Cars createInitialCarsFromInput() {
        AnnouncementPrinter.printCarNameInputAnnouncement();
        List<String> carNames = scanNullSafeCarNames();
        return Cars.of(carNames);
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
