package study.racing.step3;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createCars(int count, MovingCondition movingCondition) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car(movingCondition));
        }
        return cars;
    }
}
