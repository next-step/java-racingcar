package CarRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Competition {

    private static final int CONDITION_NUMBER = 4;
    private static final int DISTANCE_PER_TRY = 1;
    private final Random random = new Random();

    private final List<Car> cars = new ArrayList<>();

    public List<Car> moveCars() {
        for (Car car : cars) {
            car.move(drive(random.nextInt(10)));
        }
        return cars;
    }

    public int drive(int number) {
        if (number >= CONDITION_NUMBER) {
            return DISTANCE_PER_TRY;
        }

        return 0;
    }

    public List<Car> winners() {
        int max = 0;
        for (Car car: cars) {
            max = Math.max(max, car.currentPosition());
        }

        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            checkIfWinner(winnerCars, car, max);
        }

        return winnerCars;
    }

    private void checkIfWinner(List<Car> winnerCars, Car car, int max) {
        if (max == car.currentPosition()) {
            winnerCars.add(car);
        }
    }

    public void entry(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

}
