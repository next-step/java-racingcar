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

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    public static void printResult(final List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        cars.forEach(car -> {
            stringBuilder.append(getCarNameWithSuffix(car));
            stringBuilder.append(getCarFinalPosition(car));
        });
        System.out.println(stringBuilder);
    }

    private static String getCarNameWithSuffix(final Car car) {
        return car.getName() + SUFFIX_OF_CAR_NAME;
    }

    private static String getCarFinalPosition(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(POSITION_MARK);
        }
        stringBuilder.append(NEW_LINE);
        return stringBuilder.toString();
    }

    public static void printWinner(final List<Car> winnerCars) {
        String winner = getNamesOfWinnerCars(winnerCars) + WINNER_MESSAGE;
        System.out.println(winner);
    }

    private static String getNamesOfWinnerCars(final List<Car> winnerCars) {
        return winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAME_SEPARATOR));
    }
}
