package study.step4.view;

import java.util.ArrayList;
import java.util.List;

import study.step4.domain.Car;
import study.step4.domain.Cars;

public class ResultView {

    public static void showProgress(Cars cars) {
        for (Car car: cars.getCars()) {
            System.out.println(car.name() + " : " + "-".repeat(car.position().getPosition()));
        }
        System.out.println();
    }

    public static void showResult(Cars cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car: cars.getCars()) {
            winnerNames.add(car.name());
        }
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
