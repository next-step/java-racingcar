import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
