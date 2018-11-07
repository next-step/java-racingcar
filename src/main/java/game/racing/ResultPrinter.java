package game.racing;

import java.util.List;

public class ResultPrinter {


    public static void printCurrentState(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCurrentState());
        }
    }

    public static void printGameResult(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

}
