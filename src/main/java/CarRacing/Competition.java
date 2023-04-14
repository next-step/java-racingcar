package CarRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Competition {

    private static final int CONDITION_NUMBER = 4;
    private static final int DISTANCE_PER_TRY = 1;
    private static final Random random = new Random();

    private final List<Car> cars = new ArrayList<>();

    public int drive(int number) {
        if (number >= CONDITION_NUMBER) {
            return DISTANCE_PER_TRY;
        }

        return 0;
    }

    public List<Car> moveCars() {
        for (Car car : cars) {
            car.move(drive(random.nextInt(10)));
        }
        return cars;
    }

    public List<String> winners() {
        int max = 0;
        for (Car car: cars) {
            max = Math.max(max, car.currentPosition());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            checkIfWinner(winners, car, max);
        }

        return winners;
    }

    private void checkIfWinner(List<String> winners, Car car, int max) {
        if (max == car.currentPosition()) {
            winners.add(car.getName());
        }
    }

    public void entry(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

}
