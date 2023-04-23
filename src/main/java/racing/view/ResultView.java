package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {

    private static final String MARK = "-";

    public static void printRace(Cars cars, boolean isStart) {
        printTitle(isStart);
        for (Car car : cars.values()) {
            System.out.println(car.name().getNameString() + " : " + convertPositionToMark(car.position()));
        }
        System.out.println();
    }

    private static void printTitle(boolean isStart) {
        if (isStart) {
            System.out.println("실행 결과");
        }
    }

    private static String convertPositionToMark(int position) {
        return MARK.repeat(position);
    }

    public static void showWinner(Cars cars) {
        System.out.println(toWinnerString(cars.pickWinners()) + "가 최종 우승했습니다.");
    }

    private static String toWinnerString(List<String> winners) {
        return String.join(", ", winners);
    }
}
