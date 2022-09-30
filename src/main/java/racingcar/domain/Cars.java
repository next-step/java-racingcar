package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 많은 차와 관련된 객체
 */
public class Cars {
    private static RandomMoveCondition moveCondition;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static List<Car> makeCars(int num) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cars.add(new Car(moveCondition));
        }
        return cars;
    }
}
