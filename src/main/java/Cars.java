import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] carNames) {
        List<Car> receivedCars = new ArrayList<>();
        for (String carName : carNames) {
            receivedCars.add(new Car(carName));
        }

        return new Cars(receivedCars);
    }

    public boolean isValid() {
        return cars.stream().allMatch(Car::isValid);
    }

    public List<Car> getCars() {
        return cars;
    }
}
