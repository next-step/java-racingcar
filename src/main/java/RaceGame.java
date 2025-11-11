import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private final List<Car> cars;
    private final int roundCount;

    public RaceGame(int carCount, int roundCount) {
        this.cars = createCars(carCount);
        this.roundCount = roundCount;
    }

    public List<Car> cars() {
        return cars;
    }

    public void execute() {
        for (int i = 0; i < this.roundCount; i++) {
            race();
            ResultView.printResult(cars);
        }
    }

    private void race() {
        for (Car car : this.cars) {
            car.makeMove(RANDOM.nextInt(MAX_RANDOM_VALUE));
        }
    }

    private static List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
