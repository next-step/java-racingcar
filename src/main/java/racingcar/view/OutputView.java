package racingcar.view;

import racingcar.controller.RacingCar;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String BLANK = " ";
    private static final String ONE_MOVE = "-";
    private static final String DELIMITER_FOR_WINNERS = ",";
    private static final int FIRST_TRY_COUNT = 1;

    public static void printCurrentPosition(RacingCar racingCar) {
        printResultTitle(racingCar);
        printTryCount(racingCar.getCurrentCount());
        for (Car car : racingCar.getCars()) {
            printPrettierName(car, racingCar);
            printCurrentPositionOfOneCar(car.getPosition());
        }
        printBottomLine(racingCar);
    }

    private static void printResultTitle(RacingCar racingCar) {
        if (racingCar.getCurrentCount() == FIRST_TRY_COUNT) {
            System.out.println();
            System.out.println("실행결과");
        }
    }

    private static void printTryCount(int currentTryCount) {
        printBorderLine();
        System.out.println("[" + (currentTryCount) + "회차]");
        System.out.println();
    }

    private static void printPrettierName(Car car, RacingCar racingCar) {
        System.out.print(findPrettierName(car, racingCar.getCars()) + " |");
    }


    private static String findPrettierName(Car car, List<Car> cars) {
        return makeCarNamesPrettier(cars).get(cars.indexOf(car));
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

    private static void printCurrentPositionOfOneCar(int currentPosition) {
        System.out.println(convertPositionToString(currentPosition));
    }

    private static StringBuilder convertPositionToString(int position) {
        StringBuilder stringPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringPosition.append(ONE_MOVE);
        }
        return stringPosition;
    }

    public static void printWinners(List<Car> winners) {
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

    private static void printBottomLine(RacingCar racingCar) {
        if (!racingCar.isNotEnd()) {
            printBorderLine();
        }
    }
}