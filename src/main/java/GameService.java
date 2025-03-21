import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameService {
    private static final Random random = new Random();
    private final ArrayList<Car> cars = new ArrayList<>();

    public GameService(String names) {
        Arrays.stream(names.split(","))
            .forEach(name -> cars.add(new Car(name, 0)));
    }

    public void move() {
        for (Car car : cars) {
            car.randomGo(random.nextInt(10));
        }
    }

    public void printLocations() {
        for (Car car : cars) {
            ResultView.printCarLocation(car);
        }
    }

    public int carNumber() {
        return cars.size();
    }
}
