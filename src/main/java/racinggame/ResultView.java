package racinggame;

import java.util.List;

public class ResultView {

    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getStatus()));
        }
    }
}
