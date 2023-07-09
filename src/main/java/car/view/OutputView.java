package car.view;

import car.domain.CarRacingGame;
import car.domain.CarFormatter;
import car.domain.Name;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String CARS_JOIN_DELIMITER = "\n";
    private static final String NAMES_JOIN_DELIMITER = ", ";
    private static final String FORMAT_END = "\n";
    private static CarFormatter formatter = new DefaultCarFormatter();

    public static void printWinners(final CarRacingGame game) {
        System.out.println(joinNames(game.resolveWinnerNames()) + "가 최종 우승했습니다.");
    }

    public static void startPrintingResult() {
        System.out.println("\n실행 결과");
    }

    public static void printCurrentStatus(final CarRacingGame game) {
        System.out.println(joinFormattedCars(game.formatCars(formatter)) + FORMAT_END);
    }

    private static String joinFormattedCars(final List<String> formattedCars) {
        return String.join(CARS_JOIN_DELIMITER, formattedCars);
    }

    private static String joinNames(final List<Name> names) {
        return names.stream()
            .map(Name::getValue)
            .collect(Collectors.joining(NAMES_JOIN_DELIMITER));
    }
}
