package racing.domain;

public class Car {
    private final Rule rule;
    private Location location;

    public Car(Rule rule) {
        this.rule = rule;
        this.location = Location.defaultLocation();
    }

    public Location getLocation() {
        return location;
    }

    public void run() {
        if (rule.isPassedCondition()) {
            this.location = location.forward();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
               "rule=" + rule +
               ", location=" + location +
               '}';
    }
}
