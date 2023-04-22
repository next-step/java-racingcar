package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_EXECUTE_RESULT = "실행결과";
    public static final String POSITION_MAKER = "-";
    public static final String NAME_DELIMITER = ",";
    public static final String MESSAGE_WINNER_ANNOUNCEMENT = "%s가 최종 우승했습니다.";

    public static void printResultHeader() {
        System.out.println(MESSAGE_EXECUTE_RESULT);
    }

    public static void printCarsResult(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
    }

    private static void printCar(Car car) {
        System.out.print(car.name() + " : ");
        for (int i = 0; i < car.position(); i++) {
            System.out.print(POSITION_MAKER);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnersString = String.join(NAME_DELIMITER, winners);
        System.out.printf(MESSAGE_WINNER_ANNOUNCEMENT, winnersString);
    }
}
