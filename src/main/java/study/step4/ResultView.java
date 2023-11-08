package study.step4;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void showResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void showWinners(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car: cars) {
            winnerNames.add(car.getName());
        }
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
