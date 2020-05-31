package autoracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private static final Random RANDOM = new Random();
    private static final int DRIVING_THRESHOLD = 4;

    private final List<Location> history;

    public Car() {
        this.history = new ArrayList<>();
        this.history.add(Location.STARTING_LINE);
    }

    public void race() {
        race(RANDOM.nextInt(10));
    }

    public void race(int randomValue) {
        if (canGoForward(randomValue)) {
            drive(1);
            return;
        }
        stay();
    }

    public int getLastRound() {
        return history.size() - 1;
    }

    public Location getLocation(int round) {
        if (round > getLastRound()) {
            throw new IllegalArgumentException(String.format("The car has never played that round '%d'.", round));
        }
        return history.get(round);
    }

    private Location getLatestLocation() {
        return history.get(history.size() - 1);
    }

    private void drive(int distance) {
        history.add(getLatestLocation().move(distance));
    }

    private void stay() {
        drive(0);
    }

    private boolean canGoForward(int randomValue) {
        return randomValue >= DRIVING_THRESHOLD;
    }
}
