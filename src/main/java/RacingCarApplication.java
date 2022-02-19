import java.util.Objects;

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
