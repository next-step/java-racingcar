package racing.view;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Position;

import java.util.List;

public class ResultView {

    private static final String MARK = "-";

    public static void printRace(Cars cars) {
        for (Car car : cars.values()) {
            System.out.println(car.name().getValue() + " : " + convertPositionToMark(car.position()));
        }
        System.out.println();
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    private static String convertPositionToMark(Position position) {
        return MARK.repeat(position.getValue());
    }

    public static void showWinner(Cars cars) {
        System.out.println(toWinnerString(cars.pickWinners()) + "가 최종 우승했습니다.");
    }

    private static String toWinnerString(List<String> winners) {
        return String.join(", ", winners);
    }
}
