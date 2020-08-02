package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.CarRacingProperty.*;

public class CarRacing {

    private Random generator;

    private final int carCount;
    private final int tryCount;

    private List<Car> cars;

    private boolean complete = false;
    private int racingCount = 0;

    public CarRacing(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;

        initialize();
    }

    public void start() {
        if (complete) {
            return;
        }

        start(new CarRacingListener() {
                @Override
                public void carMoved(int movedDistance) {}

                @Override
                public void carMovedComplete(int totalDistance) {}

                @Override
                public void racingTriedComplete() {}
        });
    }

    public void start(CarRacingListener racingListener) {
        if (complete) {
            return;
        }

        for (int i = 0; i < tryCount; i++) {
            tryMoveCars(racingListener);
            racingListener.racingTriedComplete();
            racingCount++;
        }

        complete = (tryCount == racingCount);
    }

    public boolean isRacingComplete() {
        return complete;
    }

    public int getCarCount() {
        if (cars == null) {
            return 0;
        }
        return cars.size();
    }

    public int getRacingCount() {
        return racingCount;
    }

    private void initialize() {
        if (carCount <= 0 || tryCount <= 0) {
            complete = true;
            return;
        }

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
                racingListener.carMoved(distance);
            }
            racingListener.carMovedComplete(car.getTotalDistance());
        }
    }

    private int getRandomDistance() {
        return generator.nextInt(MAX_RANDOM_DISTANCE - MIN_RANDOM_DISTANCE + 1) + MIN_RANDOM_DISTANCE;
    }

}
