import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        int maxLocation = 0;
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() > maxLocation) {
                winners.clear();
                maxLocation = car.getLocation();
                winners.add(car);
            } else if (car.getLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}
