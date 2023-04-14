package CarRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Competition {

    private static final int CONDITION_NUMBER = 4;
    private static final int DISTANCE_PER_TRY = 1;
    private static final Random random = new Random();

    public int drive(int number) {
        if (number >= CONDITION_NUMBER) {
            return DISTANCE_PER_TRY;
        }

        return 0;
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(drive(random.nextInt(10)));
        }
    }

    public List<String> winners(List<Car> cars) {
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

    public List<Car> entry(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

}
