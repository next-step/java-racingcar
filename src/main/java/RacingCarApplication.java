import java.util.Objects;
import java.util.Random;

public class RacingCarApplication {
    public static void main(String[] args) {
        AnnouncementPrinter.printCarNameInputAnnouncement();
        String[] carNames = scanNullSafeCarNames();

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
    }

    private static String[] scanNullSafeCarNames() {
        String[] carNames = CustomScanner.scanInputCarNames();
        while (Objects.isNull(carNames)) {
            AnnouncementPrinter.printEmptyCarNameInputAnnouncement();
            carNames = CustomScanner.scanInputCarNames();
        }
        return carNames;
    }
}
