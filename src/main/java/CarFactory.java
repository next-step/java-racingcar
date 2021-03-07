import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private int numberOfCars;
    private int numberOfAdvances;

    CarFactory (int numberOfCars, int numberOfAdvances) {
        this.numberOfCars = numberOfCars;
        this.numberOfAdvances = numberOfAdvances;
    }

    public List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();
        for (int limit = 0; limit <= numberOfCars; limit++) {
            cars.add(new Car(numberOfAdvances));
        }
        return cars;
    }
}
