package racingcar;

import java.util.ArrayList;

public class ResultView {
    public void showCurrentState(ArrayList<Car> cars) {
        for (Car car : cars) {
            String dashes = "-".repeat(car.currentPosition());
            System.out.println(dashes);
        }
        System.out.println();
    }
}
