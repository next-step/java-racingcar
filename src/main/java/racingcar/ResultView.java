package racingcar;

import java.util.ArrayList;

public class ResultView {
    public void showCurrentState(ArrayList<Car> cars) {
        for (Car car : cars) {
            String dashes = "-".repeat(car.currentPosition());
            System.out.println(car.getName() + " : " + dashes);
        }
        System.out.println();
    }
}
