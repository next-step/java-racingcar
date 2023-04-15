package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {
    public static final String DASH = "-";

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(DASH.repeat(car.getPosition()));
        }
        System.out.println("################################################################");
    }
}
