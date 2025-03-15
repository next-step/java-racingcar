package racingcar;

import java.util.List;
import java.util.Random;

public class CarsMover {

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.isMove(new Random())) {
                car.move(1);
            }
        }
    }
}
