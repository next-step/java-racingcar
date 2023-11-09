package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarService {
    private static final Random random = new Random();

    public static List<Car> generate(String[] names) {
        List<Car> cars = new ArrayList<Car>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public static List<String> winnersList(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = maxCarPosition(cars);

        for (Car car : cars) {
            addWinner(car, max, winners);
        }

        return winners;
    }

    private static void addWinner(Car car, int max, List<String> winners) {
        if (max == car.currentPosition()) {
            winners.add(car.carName());
        }
    }

    private static int maxCarPosition(List<Car> cars) {
        int max = 0;

        for (Car car : cars) {
            max = max <= car.currentPosition() ? car.currentPosition() : 0;
        }
        return max;
    }

    private static int randomValue() {
        return random.nextInt(10);
    }

    public static void repeatMove(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValue());
        }
    }

}
