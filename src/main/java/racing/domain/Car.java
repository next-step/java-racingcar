package racing.domain;

public class Car {
    private Location location;

    public Car() {
        this.location = Location.defaultLocation();
    }

    public Location getLocation() {
        return location;
    }

    public void run(GameRule gameRule) {
        if (gameRule.isPassedCondition()) {
            this.location = location.forward();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
               "location=" + location +
               '}';
    }
}
