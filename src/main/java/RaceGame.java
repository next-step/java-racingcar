import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private final List<Car> cars;

    public RaceGame(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public List<Car> cars() {
        return cars;
    }

    void race() {
        for (Car car : this.cars) {
            car.makeMove(RANDOM.nextInt(MAX_RANDOM_VALUE));
        }
    }

    List<Car> getWinners() {
        int winnerLocation = findMaxLocation();
        return findCarsAtLocation(winnerLocation);
    }

    private int findMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.currentLocation(), maxLocation);
        }
        return maxLocation;
    }

    private List<Car> findCarsAtLocation(int targetLocation) {
        List<Car> locatedCars = new ArrayList<>();
        for (Car car : cars) {
            addIfLocationMatches(locatedCars, car, targetLocation);
        }
        return locatedCars;
    }

    private void addIfLocationMatches(List<Car> winners, Car car, int targetLocation) {
        if (car.currentLocation() == targetLocation) {
            winners.add(car);
        }
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name: carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
