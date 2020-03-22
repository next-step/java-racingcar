package racingcar.view;

import racingcar.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String BLANK = " ";
    private static final String ONE_MOVE = "-";
    private static final String DELIMITER_FOR_WINNERS = ",";
    private static final int FIRST_TRY_COUNT = 1;

    public static void printWinners(Winners winners) {
        System.out.println();
        String winnerResult = makeWinnersNameInOneLine(winners);
        System.out.println(">>>>>>>> " + winnerResult + " (이)가 최종 우승했습니다. <<<<<<<<");
    }

    public static void printGame(Cars cars, Results results) {
        printResultTitle();
        printGameResults(cars, results);
    }

    private static String makeWinnersNameInOneLine(Winners winners) {
        return winners.getWinners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER_FOR_WINNERS));
    }

    private static void printResultTitle() {
        System.out.println("실행결과");
    }

    private static void printGameResults(Cars cars, Results results) {
        int currentTryCount = FIRST_TRY_COUNT;
        for (Result result : results.getResults()) {
            printTryCount(currentTryCount);
            printCarsAfterMoveOnce(cars, result);
            currentTryCount++;
        }
        printBorderLine();
    }

    private static void printTryCount(int currentTryCount) {
        printBorderLine();
        System.out.println("[" + (currentTryCount) + "회차]");
        System.out.println();
    }

    private static void printCarsAfterMoveOnce(Cars cars, Result result) {
        List<String> carNames = makeCarNamesPrettier(cars.getCars());
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " |");
            printCurrentPosition(result.getResult().get(i));
        }
    }

    private static void printCurrentPosition(int currentPosition) {
        System.out.println(convertPositionToString(currentPosition));
    }

    private static StringBuilder convertPositionToString(int position) {
        StringBuilder strPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            strPosition.append(ONE_MOVE);
        }
        return strPosition;
    }

    private static List<String> makeCarNamesPrettier(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return cars.stream()
                .map(it -> it.getName())
                .map(it -> it + makeBlankSpace(findLongestNameLength(carNames) - it.length()))
                .collect(Collectors.toList());
    }

    private static StringBuilder makeBlankSpace(int blankLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < blankLength; i++) {
            stringBuilder.append(BLANK);
        }
        return stringBuilder;
    }

    private static int findLongestNameLength(List<String> carNames) {
        return carNames.stream()
                .map(it -> it.length())
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    private static void printBorderLine() {
        System.out.println("=====================================");
    }
}