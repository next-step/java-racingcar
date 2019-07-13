package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String COLON = " : ";
    private static final String FINAL_MESSAGE = "가 최종 우승했습니다.";

    public static void printGameMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + COLON);
            printDistance(car);
            System.out.println();
        }
        System.out.println();
    }

    public static void printDistance(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void printWinners(List<Car> winners) {
        ArrayList winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        System.out.print(String.join(", ", winnerNames));
        System.out.println(FINAL_MESSAGE);
    }
}
