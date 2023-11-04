package study.carracing.ui;

import study.carracing.domain.Car;

import java.util.List;

public class ResultView {

    private static final String PROGRESS_DASH = "-";

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(PROGRESS_DASH.repeat(car.getPosition()));
        }
        System.out.println();
    }
}
