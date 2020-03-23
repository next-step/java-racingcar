package racingcar.view;

import racingcar.controller.RacingCar;
import racingcar.model.Car;
import racingcar.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String BLANK = " ";
    private static final String ONE_MOVE = "-";
    private static final String DELIMITER_FOR_WINNERS = ",";
    private static final int FIRST_TRY_COUNT = 1;

    public static void print(RacingCar racingCar) {
        printGame(racingCar.getCars(), racingCar.getResults());
        printWinners(racingCar.getWinners());
    }

    private static void printGame(List<Car> cars, List<Result> results) {
        System.out.println();
        printResultTitle();
        printGameResults(cars, results);
    }

    private static void printResultTitle() {
        System.out.println("실행결과");
    }

    private static void printGameResults(List<Car> cars, List<Result> results) {
        int currentTryCount = FIRST_TRY_COUNT;
        for (Result result : results) {
            printTryCount(currentTryCount);
            printGameAfterMoveOnce(cars, result);
            currentTryCount++;
        }
        printBorderLine();
    }

    private static void printTryCount(int currentTryCount) {
        printBorderLine();
        System.out.println("[" + (currentTryCount) + "회차]");
        System.out.println();
    }

    private static void printGameAfterMoveOnce(List<Car> cars, Result result) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.print(findPrettierName(car, cars) + " |");
            printCurrentPosition(result.getCurrentPosition(car.getName()));
        }
    }

    private static String findPrettierName(Car car, List<Car> cars) {
        return makeCarNamesPrettier(cars).get(cars.indexOf(car));
    }

    private static void printCurrentPosition(int currentPosition) {
        System.out.println(convertPositionToString(currentPosition));
    }

    private static StringBuilder convertPositionToString(int position) {
        StringBuilder stringPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringPosition.append(ONE_MOVE);
        }
        return stringPosition;
    }

    private static List<String> makeCarNamesPrettier(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return cars.stream()
                .map(it -> it.getName())
                .map(it -> it + makeBlankSpaceForCarName(findLongestNameLength(carNames) - it.length()))
                .collect(Collectors.toList());
    }

    private static StringBuilder makeBlankSpaceForCarName(int blankLength) {
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

    private static void printWinners(List<Car> winners) {
        System.out.println();
        String winnersInOneLine = makeWinnersNameInOneLine(winners);
        System.out.println(">>>>>>>> " + winnersInOneLine + " (이)가 최종 우승했습니다. <<<<<<<<");
    }

    private static String makeWinnersNameInOneLine(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER_FOR_WINNERS));
    }

    private static void printBorderLine() {
        System.out.println("=====================================");
    }
}