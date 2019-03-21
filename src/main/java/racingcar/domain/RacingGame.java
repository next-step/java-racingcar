package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int RANDOM_BOUND = 10;
    private int time;
    private List<Car> cars;

    public RacingGame(List<Car> cars, int time) {
        this.time = time;
        this.cars = cars;
    }

    private static int randomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    public List<Car> racing() {
        for (Car car : cars) {
            int randomValue = randomValue();
            car.move(randomValue);
        }

        return cars;
    }

    static List<Car> sortByValue(List<Car> carList) {
        carList.sort((o1, o2) -> {
            if (o1.getPosition() < o2.getPosition()) return 1;
            return -1;
        });

        return carList;
    }

    public static List<Car> getWinners(List<Car> cars) {
        sortByValue(cars);
        List<Car> winners = new ArrayList<>();
        Car winner = cars.get(0);

        for (Car car : cars) {
            checkWinner(car, winner, winners);
        }

        return winners;
    }

    private static void checkWinner(Car car, Car winner, List<Car> winners) {
        if (car.isMaxPosition(winner)) {
            winners.add(car);
        }
    }
}
