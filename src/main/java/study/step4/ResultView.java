package study.step4;

import java.util.List;

public class ResultView {

    public static void showResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
