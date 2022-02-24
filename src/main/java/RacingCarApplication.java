import core.Cars;
import core.Winners;
import utils.AnnouncementPrinter;
import utils.CustomScanner;

import java.util.List;
import java.util.Random;

public class RacingCarApplication {
    public static void main(String[] args) {
        AnnouncementPrinter.printCarNameInputAnnouncement();
        List<String> carNames = scanNullSafeCarNames();

        Cars cars = Cars.of(carNames);
        while (Boolean.FALSE.equals(cars.isValid())) {
            AnnouncementPrinter.printCarNameInvalidAnnouncement();
            carNames = scanNullSafeCarNames();
            cars = Cars.of(carNames);
        }

        AnnouncementPrinter.printMoveCountInputAnnouncement();
        int moveCount = CustomScanner.scanMoveCount();

        AnnouncementPrinter.printMoveResultAnnouncement();
        for (int i = 0; i < moveCount; i++) {
            cars.moveRandom(new Random());
            cars.printPositions();
            System.out.println();
        }

        Winners winners = Winners.decideWinners(cars);
        winners.printWinners();
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
