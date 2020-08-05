package step3.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RacingCar {

    public static Map<Integer, Car> preparedCar(int racingCarNumber) {
        Map<Integer, Car> map = new HashMap<>();

        for (int i = 1; i <= racingCarNumber; i++) {
            Car car = new Car(i);
            map.put(car.getCarId(), car);
        }
        return map;
    }

    public static int getAccelateNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static String racing(Car car, int racingCondition) {
        if (racingCondition > 3) {
            return car.accelerate();
        }
        return car.brake();
    }
    
}
