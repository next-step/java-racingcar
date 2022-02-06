package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Race {

    private static final int MOVE_THRESHOLD = 4;
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Car> winners = new ArrayList<>();

    public void execute() {
        String[] carNames = InputView.getName();
        setCars(carNames);
        int times = InputView.getTimes();
        while ((times--) > 0) {
            playGame(cars);
        }
        setWinners(cars);
        OutputView.printWinners(winners);
    }

    public static void setCars(String[] carNames) {
        for (String carName: carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        isValidCarNames(cars);
    }

    private static void isValidCarNames(ArrayList<Car> cars) {
        for (Car car: cars) {
            if (!InputView.isValidCarName(car.name)) {
                throw new IllegalArgumentException("Error: Invalid car name");
            }
        }
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

    public static void setWinners(ArrayList<Car> cars) {
        int maximum = getMaxScore(cars);
        for (Car car: cars) {
            if (isWinner(car, maximum)) {
                winners.add(car);
            }
        }
    }

    public static boolean isWinner(Car car, int maximum) {
        return car.distance == maximum;
    }
}
