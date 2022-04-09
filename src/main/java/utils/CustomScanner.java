package utils;

import core.CarName;

import java.util.*;

public class CustomScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<CarName> scanValidCarNames() {
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

    private static List<String> scanNullSafeCarNames() {
        List<String> carNames = scanInputCarNames();
        while (carNames.isEmpty()) {
            AnnouncementPrinter.printEmptyCarNameInputAnnouncement();
            carNames = scanInputCarNames();
        }
        return carNames;
    }

    private static List<String> scanInputCarNames() {
        String inputLine = scanner.nextLine();

        if (inputLine.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(inputLine.split(","));
    }

    public static int scanMoveCount() {
        AnnouncementPrinter.printMoveCountInputAnnouncement();
        return scanner.nextInt();
    }
}
