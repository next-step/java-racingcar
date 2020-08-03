package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.domain.CarRacingProperty.MAX_RANDOM_DISTANCE;
import static racing.domain.CarRacingProperty.MIN_RANDOM_DISTANCE;

public class CarRacing {

    private final int carCount;
    private final int tryCount;

    private Random random;
    private List<Car> cars;

    private boolean complete = false;
    private int racingCount = 0;


    public CarRacing(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;

        initialize();
    }

    public void race() {
        race(null);
    }

    public void race(RaceFunction mappingFunction) {
        tryMoveCars(mappingFunction);
        racingCount++;
        complete = tryCount == racingCount;
    }

    public boolean isComplete() {
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

        random = new Random();
        cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void tryMoveCars(RaceFunction mappingFunction) {
        for (Car car : cars) {
            car.move(getRandomDistance());
            if (mappingFunction != null) {
                mappingFunction.compute(car.getDistance());
            }
        }
    }

    public int getRandomDistance() {
        return random.nextInt(MAX_RANDOM_DISTANCE - MIN_RANDOM_DISTANCE + 1) + MIN_RANDOM_DISTANCE;
    }
}
