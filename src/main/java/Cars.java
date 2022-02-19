import java.util.*;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
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

    public void moveRandom(Random random) {
        for (Car car : cars) {
            car.moveRandom(random);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
