package step3.study;

import java.util.List;

public class RacingManager {
    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }
}
