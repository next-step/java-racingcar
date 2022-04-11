package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Competition {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final List<Car> cars;
    private final int round;
    private Movable movable;

    public Competition(int unit, int round, Movable movable) {
        cars = new ArrayList<>(unit);
        for (int i = 0; i < unit; i++) {
            cars.add(i, new Car(movable));
        }

        this.round = round;
    }

    public List<Car> progressCompetition() {
        for (int i = 0; i < round; i++) {
            progressEachRound();
        }

        return cars;
    }

    public List<Car> progressEachRound() {
        for (Car car : cars) {
            car.accumulateOneRound(createRandomNumber());
        }

        return cars;
    }

    private int createRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }
}
