package racing.domain;

public class Car {
    private final GameRule gameRule;
    private Location location;

    public Car(GameRule gameRule) {
        this.gameRule = gameRule;
        this.location = Location.defaultLocation();
    }

    public Location getLocation() {
        return location;
    }

    public void run() {
        if (gameRule.isPassedCondition()) {
            this.location = location.forward();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
               "gameRule=" + gameRule +
               ", location=" + location +
               '}';
    }
}
