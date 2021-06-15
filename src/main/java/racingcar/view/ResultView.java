package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSGAE = "실행결과";
    private static final String CAR_NAME_SEPARATOR = " : ";
    private static final String HYPHEN = "-";
    private static final String WINNER_NAMES_SEPARATOR = ", ";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void showResult() {
        System.out.println(RESULT_MESSGAE);
    }

    public static void cycleCarInformation(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.print(cars.getCars().get(i).getName() + CAR_NAME_SEPARATOR);
            showCarLocationInfo(cars.getCars().get(i).getLocation());
            System.out.println();
        }
    }

    private static void showCarLocationInfo(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print(HYPHEN);
        }
    }

    public static void showWinner(List<Car> winnerNames) {
        String names = winnerNames.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAMES_SEPARATOR));
        System.out.print(WINNER_MESSAGE + names);
    }
}
