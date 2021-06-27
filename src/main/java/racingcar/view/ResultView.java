package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_NAME_SEPARATOR = " : ";
    private static final String HYPHEN = "-";
    private static final String WINNER_NAMES_SEPARATOR = ", ";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void showResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void showCarInformationDuringCycle(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + CAR_NAME_SEPARATOR);
            showCarLocationInfo(car.getLocation());
            System.out.println();
        }
    }

    private static void showCarLocationInfo(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print(HYPHEN);
        }
    }

    public static void showWinner(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAMES_SEPARATOR));
        System.out.print(WINNER_MESSAGE + names);
    }
}
