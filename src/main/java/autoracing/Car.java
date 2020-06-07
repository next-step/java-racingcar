package autoracing;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final RacingRule NO_RULE = () -> {
        System.out.println("WARN: the car has no rule.");
        return false;
    };

    private final String name;
    private final List<Location> history;
    private RacingRule rule;

    public Car(String name, RacingRule rule) {
        this.name = name;
        this.history = new ArrayList<>();
        this.history.add(Location.STARTING_LINE);
        this.rule = rule;
    }

    public Car(String name) {
        this(name, NO_RULE);
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

    public void setRule(RacingRule rule) {
        this.rule = rule;
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
