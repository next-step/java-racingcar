package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;
import racingcar.message.DefaultMessages;

import java.util.List;

public class ResultView {
    private static final String DISTANCE_UNIT = "-";
    private static final String DELIMITER = ", ";
    private static final String WINNER_STATEMENT = "가 최종 우승했습니다.";

    public static void printResultMessage() {
        System.out.println(DefaultMessages.SHOW_RESULT);
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.join(DELIMITER, winners.getNames()) + WINNER_STATEMENT);
    }

    public static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(generateCarPositionString(car));
        }
        System.out.println();
    }

    private static String generateCarPositionString(Car car) {
        String carPositionString = positionToString(car.position());
        return car.name() + " : " + carPositionString;
    }

    private static String positionToString(int cnt) {
        return DISTANCE_UNIT.repeat(Math.max(0, cnt));
    }
}
