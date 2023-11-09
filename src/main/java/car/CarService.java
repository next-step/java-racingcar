package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarService {
    private static final Random random = new Random();

    public static List<Car> generate(String[] names) {
        List<Car> cars = new ArrayList<Car>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private static int randomValue() {
        return random.nextInt(10);
    }

    public static void repeatMove(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValue());
        }
    }

}
