package racinggame.domain.result;

public class CarSnapshot {
    private final String name;
    private final int location;

    private CarSnapshot(String name, final int location) {
        this.name = name;
        this.location = location;
    }

    public static CarSnapshot of(String name, int location) {
        return new CarSnapshot(name, location);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
