package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Cars;

import java.util.List;

public class ResultView {

    private static final String DELIMITER = ",";
    private static final String MOVE_MARK = "-";
    private static final String S_GAME_RESULT = "실행 결과";
    private static final String MSG_FINAL_WINNERS = "가 최종 우승했습니다.";

    public static void printGameResult() {
        System.out.println(S_GAME_RESULT);
    }

    public static void printPlayResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarPosition(car);
        }
    }

    public static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPos(); i++) {
            System.out.print(MOVE_MARK);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(DELIMITER, winners) + MSG_FINAL_WINNERS);
    }
}
