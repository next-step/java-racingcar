package racingcar;

import java.util.ArrayList;

public class ResultView {
    public void showCurrentState(ArrayList<Car> cars) {
        for (Car car : cars) {
            String dashes = "-".repeat(car.getCurrentDistance());
            System.out.println(dashes);
        }
        System.out.println();
    }
}
