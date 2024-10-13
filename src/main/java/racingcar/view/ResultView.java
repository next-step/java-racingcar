package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingWinners;

import java.util.List;

public class ResultView {

    private static final String MOVE_UNIT = "-";
    public static void print(List<Car> cars){
        for (Car car : cars) {
            printCarMovement(car);
        }
        System.out.println();
    }

    public static void printCarMovement(Car car) {
        System.out.println(car.getName() + ": "
                + draw(car.currentPosition()));
    }

    private static String draw(int currentPosition) {
        StringBuilder draw = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            draw.append(MOVE_UNIT);
        }

        return draw.toString();
    }

    public static void printWinner(RacingWinners winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}