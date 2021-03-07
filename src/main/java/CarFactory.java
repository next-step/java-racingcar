import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private int numberOfCars;

    CarFactory (int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();
        for (int limit = 0; limit < numberOfCars; limit++) {
            cars.add(new Car());
        }
        return cars;
    }
}
