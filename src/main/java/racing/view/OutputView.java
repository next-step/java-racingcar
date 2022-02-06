package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.Car;
import racing.domain.car.Cars;

public class OutputView {

    private static final String SEPARATOR_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MOVE_STATE = "-";
    private static final String COMMA = ", ";

    private OutputView() {
    }

    public static void printGameResult(List<Cars> raceStates) {
        System.out.println("\n실행 결과");
        for (Cars raceState : raceStates) {
            printCarHistories(raceState);
            System.out.println();
        }
    }

    private static void printCarHistories(Cars raceState) {
        for (Car car : raceState.getCars()) {
            printCarHistory(car);
            System.out.println();
        }
    }

    private static void printCarHistory(Car car) {
        System.out.print(car.getNameValue() + SEPARATOR_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < car.getPositionValue(); i++) {
            System.out.print(MOVE_STATE);
        }
    }

    public static void printWinners(List<Car> winners) {
        System.out.println("최종 우승자 : " + winners.stream().map(Car::getNameValue).collect(Collectors.joining(COMMA)));
    }
}
