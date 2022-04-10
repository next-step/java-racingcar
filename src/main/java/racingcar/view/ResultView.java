package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void renderResultView(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getPositionView());
        }
        System.out.println("");
    }
}
