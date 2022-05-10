package utils;

import core.CarName;

import java.io.InputStream;
import java.util.*;

public class CustomScanner {
    private final Scanner scanner;

    private CustomScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static CustomScanner create(InputStream inputStream) {
        return new CustomScanner(new Scanner(inputStream));
    }

    public List<CarName> scanValidCarNames() {
        try {
            List<String> inputCarNames = scanNullSafeCarNames();
            List<CarName> carNames = new ArrayList<>();
            for (String inputCarName : inputCarNames) {
                carNames.add(CarName.create(inputCarName));
            }
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanValidCarNames();
        }
    }

    private List<String> scanNullSafeCarNames() {
        List<String> carNames = scanInputCarNames();
        while (carNames.isEmpty()) {
            AnnouncementPrinter.printEmptyCarNameInputAnnouncement();
            carNames = scanInputCarNames();
        }
        return carNames;
    }

    private List<String> scanInputCarNames() {
        String inputLine = scanner.nextLine();

        if (inputLine.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(inputLine.split(","));
    }

    public int scanMoveCount() {
        AnnouncementPrinter.printMoveCountInputAnnouncement();
        return scanner.nextInt();
    }
}
