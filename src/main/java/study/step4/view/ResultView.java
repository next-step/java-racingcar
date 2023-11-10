package study.step4.view;

import java.util.ArrayList;
import java.util.List;

import study.step4.domain.Car;

public class ResultView {

    public static void showResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static List<String> getWinners(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car: cars) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

    public static void show(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
