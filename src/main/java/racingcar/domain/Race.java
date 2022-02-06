package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.view.OutputView;

public class Race {

    private final static ArrayList<Car> winners = new ArrayList<>();

    public static void playGames(List<Car> cars, int times) {
        while ((times--) > 0) {
            Race.playGame(cars);
            OutputView.printResult(cars);
        }
    }

    public static void playGame(List<Car> cars) {
        for (Car car: cars) {
            int randomNumber = Race.getRandomNumber();
            car.moveCarRandomly(randomNumber);
        }
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

    public static ArrayList<Car> getWinners() {
        return winners;
    }

    public static boolean isWinner(Car car, int maximum) {
        return car.getDistance() == maximum;
    }
}
