package step4.view;

import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.ResultSheet;
import step4.domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String WINNER_ANNOUNCE_POSTFIX = "가 최종 우승했습니다.";
    private static final String POSITION_OF_CAR = "-";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private static final String CAR_NAME_SEPARATOR = " : ";

    public static void readResultSheet(ResultSheet resultSheet) {
        showResultTitle();
        for (Cars cars : resultSheet.getResultSheet()) {
            showResult(cars);
        }
    }

    public static void printWinners(Winners winners) {
        List<String> winnerNames = winners.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(separateWinnerNames(winnerNames) + WINNER_ANNOUNCE_POSTFIX);
    }

    public static void showResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCars(car);
        }
        printEmptyLine();
    }

    private static void printCars(Car car) {
        printCarName(car.getName());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_OF_CAR);
        }
        printEmptyLine();
    }

    private static void showResultTitle() {
        printEmptyLine();
        System.out.println(RESULT_TITLE);
        printEmptyLine();
    }

    private static void printCarName(String carName) {
        System.out.print(carName + CAR_NAME_SEPARATOR);
    }

    private static String separateWinnerNames(List<String> winnerNames) {
        return winnerNames.stream()
                .reduce((s, s2) -> s + WINNER_NAME_SEPARATOR + s2)
                .get();
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
