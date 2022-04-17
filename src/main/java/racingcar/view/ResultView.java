package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private ResultView() {}

    public static void printResult(List<Car> racingCars) {
        for(Car car : racingCars) {
            System.out.println(car.getCurrentPosition());
        }
        System.out.println();
    }

    public static void printResultStartMessage() {
        System.out.println("실행 결과");
    }
}
