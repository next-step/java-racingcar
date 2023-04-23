package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;


public class ResultView {
    public static final String DASH = "-";

    public static void printResult(Cars cars) {
        for (Car car : cars.getCar()) {
            System.out.println(DASH.repeat(car.getPosition()));
        }
        System.out.println("################################################################");
    }
}
