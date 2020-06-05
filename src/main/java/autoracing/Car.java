package autoracing;

import java.util.Arrays;
import java.util.List;

public class Car {
    private final List<Location> history;
    private final RacingRule rule;

    public Car(RacingRule rule) {
        this.history = Arrays.asList(Location.STARTING_LINE);
        this.rule = rule;
    }

    public void race() {
        if (rule.canGoForward()) {
            drive(1);
            return;
        }
        stay();
    }

    public Location getLocation(int round) {
        if (round > getLastRound()) {
            throw new IllegalArgumentException(String.format("The car has never played that round '%d'.", round));
        }
        return history.get(round);
    }

    private Location getLatestLocation() {
        return history.get(getLastRound());
    }

    private int getLastRound() {
        return history.size() - 1;
    }

    private void drive(int distance) {
        history.add(getLatestLocation().move(distance));
    }

    private void stay() {
        drive(0);
    }
}
