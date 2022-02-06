package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private final static ArrayList<Car> winners = new ArrayList<>();

    public void execute() {
        List<String> carNames = InputView.getName();
        Cars cars = Cars.of(carNames);
        int times = InputView.getTimes();
        while ((times--) > 0) {
            playGame(cars.getCars());
        }
        setWinners(cars.getCars());
        OutputView.printWinners(winners);
    }

    public static void playGame(List<Car> cars) {
        for (Car car: cars) {
            int randomNumber = Race.getRandomNumber();
            car.moveCarRandomly(randomNumber);
        }
        OutputView.printResult(cars);
        System.out.println();
    }

    public static int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public static int getMaxScore(List<Car> cars) {
        int maximum = 0;
        for (Car car: cars) {
            maximum = Math.max(maximum, car.getDistance());
        }
        return maximum;
    }

    public static void setWinners(List<Car> cars) {
        int maximum = getMaxScore(cars);
        for (Car car: cars) {
            if (isWinner(car, maximum)) {
                winners.add(car);
            }
        }
    }

    public static boolean isWinner(Car car, int maximum) {
        return car.getDistance() == maximum;
    }
}
