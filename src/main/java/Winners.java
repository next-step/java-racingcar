import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> cars;

    private Winners(List<Car> cars) {
        this.cars = cars;
    }

    public static Winners decideWinners(Cars cars) {
        List<Car> result = new ArrayList<>();
        int currentMaxPosition = 0;
        for (Car car : cars.getCars()) {
            currentMaxPosition = comparePosition(result, currentMaxPosition, car);
        }
        return new Winners(result);
    }

    private static int comparePosition(List<Car> result, int currentMaxPosition, Car car) {
        if (car.getPosition() > currentMaxPosition) {
            currentMaxPosition = car.getPosition();
            result.clear();
            result.add(car);
        } else if (car.getPosition() == currentMaxPosition) {
            result.add(car);
        }
        return currentMaxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
