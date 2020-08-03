package racing.domain;

import java.util.Random;

import static racing.domain.CarRacingProperty.*;

public class Car {

    private final Random random;

    private int totalDistance = 0;

    public Car() {
        random = new Random();
    }

    public int move() {
        return move(null);
    }

    public int move(RaceFunction function) {
        int distance = getRandomDistance();
        distance = distance >= MIN_MOVABLE_DISTANCE ? distance : 0;
        totalDistance += distance;
        if (function != null) {
            function.compute(distance, totalDistance);
        }
        return distance;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getRandomDistance() {
        return random.nextInt(MAX_RANDOM_DISTANCE - MIN_RANDOM_DISTANCE + 1) + MIN_RANDOM_DISTANCE;
    }
}
