import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(int numOfCars) {
        cars = new ArrayList<>();

        for (int count = 1; count <= numOfCars; count++) {
            cars.add(new Car(0));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move(car.speedOf());
        }
    }

    public List<Integer> distance() {
        return cars.stream().map(Car::getDistance).collect(Collectors.toList());
    }
}
