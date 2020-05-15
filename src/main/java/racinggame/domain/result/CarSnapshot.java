package racinggame.domain.result;

public class CarSnapshot {
    private final String name;
    private final int location;

    public CarSnapshot(String name, final int location) {
        this.name = name;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
