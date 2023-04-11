package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRace {
    private static final Random random = new Random();

    public static List<Car> readyCars(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(1));
        }
        return cars;
    }

    public static List<Car> moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveOrStop(car);
        }
        return cars;
    }

    public static Car moveOrStop(Car car) {
        int randomInt = random.nextInt(10);
        if (car.canMove(randomInt)) {
            car.moveForward();
            return car;
        }
        return car;
    }

    public static void main(String[] args) {
        int carNumber = InputView.readCarNumber();
        int trialNumber = InputView.readTrialNumber();
        ResultView.raceStart();

        List<Car> cars = readyCars(carNumber);
        for (int i = 0; i < trialNumber; i++) {
            ResultView.displayCars(cars);
            moveCars(cars);
        }
    }
}
