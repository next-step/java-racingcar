package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_MARK = "-";
    private static final String SUFFIX_OF_CAR_NAME = " : ";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private static final String WINNER_MESSAGE = " 가 최종 우승했습니다.";

    private static StringBuilder stringBuilder;

    private static void initStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    public static void printResult(final List<Car> cars) {
        initStringBuilder();
        cars.forEach(car -> {
            printName(car);
            printPosition(car);
        });
        System.out.println(stringBuilder);
    }

    private static void printName(final Car car) {
        stringBuilder.append(car.getName())
                .append(SUFFIX_OF_CAR_NAME);
    }

    private static void printPosition(final Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(POSITION_MARK);
        }
        addNewLine();
    }

    private static void addNewLine() {
        stringBuilder.append(NEW_LINE);
    }

    public static void printWinner(final List<Car> winnerCars) {
        initStringBuilder();
        stringBuilder.append(getNamesOfWinnerCars(winnerCars))
                .append(WINNER_MESSAGE);
        System.out.println(stringBuilder);
    }

    private static String getNamesOfWinnerCars(final List<Car> winnerCars) {
        return winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAME_SEPARATOR));
    }
}
