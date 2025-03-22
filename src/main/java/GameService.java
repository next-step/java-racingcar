import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameService {
    private static final Random random = new Random();
    private List<Car> cars = new ArrayList<>();

    public GameService(String carNames) {
        Arrays.stream(carNames.split(","))
            .forEach(name -> cars.add(new Car(name, 0)));
    }

    public GameService(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.randomGo(random.nextInt(10));
        }
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return filterWinners(getMaxLocation());
    }

    private int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = car.max(maxLocation);
        }
        return maxLocation;
    }

    private List<Car> filterWinners(int maxLocation) {
        return cars.stream()
                .filter(car -> car.isSameLocation(maxLocation))
                .collect(Collectors.toList());
    }
}
