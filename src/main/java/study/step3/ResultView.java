package study.step3;

import java.util.List;

public class ResultView {


    public static void showResultTitle() {
        System.out.println("\n실행 결과");
    }

    public static void showResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
