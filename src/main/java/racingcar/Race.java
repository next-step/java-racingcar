package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Race {

    private static final int MOVE_THRESHOLD = 4;

    public static void execute() {
        ArrayList<Car> cars = new ArrayList<>();
        String[] carNames = InputView.getName();
        for (String carName: carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        if (!isValidCarNames(cars)) {
            return;
        }

        int times = InputView.getTimes();
        while ((times--) > 0) {
            playGame(cars);
        }
        ArrayList<Car> winners = getWinners(cars);
        OutputView.printWinners(winners);
    }

    private static boolean isValidCarNames(ArrayList<Car> cars) {
        for (Car car: cars) {
            if (!InputView.isValidCarName(car.name)) {
                return false;
            }
        }

        return true;
    }

    public static void playGame(ArrayList<Car> cars) {
        for (Car car: cars) {
            int randomNumber = Race.getRandomNumber();
            Race.moveCarRandomly(car, randomNumber);
        }
        OutputView.printResult(cars);
        System.out.println();
    }

    public static int getRandomNumber() {
        int randomNumber = new Random().nextInt(10);
        return randomNumber;
    }

    public static void moveCarRandomly(Car car, int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            car.distance++;
        }
    }

    public static int getMaxScore(ArrayList<Car> cars) {
        int maximum = 0;
        for (Car car: cars) {
            maximum = Math.max(maximum, car.distance);
        }
        return maximum;
    }

    public static ArrayList<Car> getWinners(ArrayList<Car> cars) {
        int maximum = getMaxScore(cars);

        ArrayList<Car> winners = new ArrayList<>();
        for (Car car: cars) {
            if (car.distance == maximum) {
                winners.add(car);
            }
        }

        return winners;
    }
}
