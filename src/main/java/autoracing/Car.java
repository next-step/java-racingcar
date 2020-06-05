package autoracing;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private final List<Location> history;
    private final RacingRule rule;

    public Car(String name, RacingRule rule) {
        this.name = name;
        this.history = new ArrayList<>();
        this.history.add(Location.STARTING_LINE);
        this.rule = rule;
    }

    public void race() {
        if (rule.canGoForward()) {
            drive(1);
            return;
        }
        stay();
    }

    public String getName() {
        return name;
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
