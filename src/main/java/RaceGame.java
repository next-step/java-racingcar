import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private final List<Car> cars;

    RaceGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> cars() {
        return cars;
    }

    void race() {
        for (Car car : this.cars) {
            car.makeMove(RANDOM.nextInt(MAX_RANDOM_VALUE));
        }
    }

    Winners getWinners() {
        return new Winners(cars);
    }
}
