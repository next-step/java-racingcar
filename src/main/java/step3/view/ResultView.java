package step3.view;

import step3.model.Car;

import java.util.List;

public class ResultView {

    public static void printRacingResultStartText() {
        System.out.println("실행 결과");
    }

    public static void printRacingStatus(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }
}
