package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarService {
    public static List<Car> generate(int count) {
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public static int randomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static void repeatMove(List<Car> cars) {
        for (Car car : cars) {
            car.moveAndRecord(randomValue());
        }
    }
}
