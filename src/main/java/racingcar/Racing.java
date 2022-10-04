package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static List<Integer> race(Cars cars) {
        cars.moveAll();

        List<Integer> result = new ArrayList<>();
        for (Car car : cars.carList()) {
            result.add(car.totalMoveCount());
        }

        return result;
    }
}
