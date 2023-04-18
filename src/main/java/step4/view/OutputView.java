package step4.view;

import step4.service.RacingCarGame;
import step4.domain.Name;
import step4.domain.Position;

import java.util.List;

public class OutputView {

    private static final char CAR_DISTANCE_CHARACTER = '-';
    private static final String PRINT_DELIMITER = " : ";

    private OutputView() {
    }

    public static void printResultConsole() {
        System.out.println("\n실행 결과");
    }

    public static void printWinners(List<Name> names) {
        final String winnerNames = Name.parseWinnerNames(names);

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public static void printCars(RacingCarGame cars) {
        printCars(cars.carNames(), cars.carPositions());
        printNewLine();
    }

    private static void printCars(List<Name> names, List<Position> positions) {
        final int size = names.size();

        for (int i = 0; i < size; i++) {
            printName(names.get(i));
            printDelimiter(PRINT_DELIMITER);
            printPositions(positions.get(i));
            printNewLine();
        }
    }

    private static void printName(Name name) {
        System.out.print(name.getName());
    }

    private static void printDelimiter(String delimiter) {
        System.out.print(delimiter);
    }

    private static void printPositions(Position position) {
        for (int i = 0; i < position.getDistance(); i++) {
            System.out.print(CAR_DISTANCE_CHARACTER);
        }
    }

    public static void printNewLine() {
        System.out.println();
    }

}
