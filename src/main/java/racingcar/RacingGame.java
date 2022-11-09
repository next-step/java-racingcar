package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final Random random = new Random();

    private static final int RANDOM_BOUND = 10;

    public static List<Car> getWinner(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    public List<Car> carMoveRandom(List<Car> before) {
        return before.stream().map(car -> car.move(getRandomNumber())).collect(Collectors.toList());
    }

    protected int getRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }

}
