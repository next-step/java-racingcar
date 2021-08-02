package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private String name;
    private final List<Integer> distance = new ArrayList<>();
    private int maxTryCount;
    private static final int MINIMUM_BOUND = 4;
    private static final int FORWARD = 1;
    private static final int STOP = 0;

    private Car() {

    }

    private Car(int tryCount, String name) {
        this.maxTryCount = tryCount;
        this.name = name;
        distance.add(FORWARD);
    }

    public static Car of(int tryCount, String name) {
        return new Car(tryCount, name);
    }

    public void move() {
        for (int i = 0; i < maxTryCount; i++) {
            distance.add(movable() ? FORWARD : STOP);
        }
    }

    public int getDistance(int tryCount) {
        return (int) distance.stream()
                .limit(tryCount)
                .filter(i -> i == FORWARD)
                .count();
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getDistance() {
        return this.distance;
    }

    public int getMaxTryCount() {
        return this.maxTryCount;
    }

    private boolean movable() {
        Random random = new Random();
        return random.nextInt(10) >= MINIMUM_BOUND;
    }

}
