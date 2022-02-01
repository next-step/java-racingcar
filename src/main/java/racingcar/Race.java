package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Race {

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
        OutputView.printWinners(cars);
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

        if (randomNumber >= 4) {
    public static void moveCarRandomly(Car car, int randomNumber) {
            car.distance++;
        }
    }
}
