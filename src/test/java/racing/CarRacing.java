package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private static final int MIN_RANDOM_DISTANCE = 0;

    private static final int MAX_RANDOM_DISTANCE = 9;

    private static final int MIN_MOVABLE_DISTANCE = 4;

    private Random generator;

    private final int carCount;
    private final int tryCount;

    private List<Car> cars;

    public CarRacing(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;

        initialize();
    }

    public void start(CarRacingListener racingListener) {
        for (int i = 0; i < tryCount; i++) {
            tryMoveCars(racingListener);
            racingListener.racingTriedComplete();
        }
    }

    private void initialize() {
        if (carCount <= 0 || tryCount <= 0) return;

        generator = new Random();
        cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void tryMoveCars(CarRacingListener racingListener) {
        for (Car car : cars) {
            int distance = getRandomDistance();
            if (distance >= MIN_MOVABLE_DISTANCE) {
                car.move(distance);
            }
            racingListener.carMoved(car.getMovedDistance());
        }
    }

    private int getRandomDistance() {
        return generator.nextInt(MAX_RANDOM_DISTANCE - MIN_RANDOM_DISTANCE + 1) + MIN_RANDOM_DISTANCE;
    }

}
