package racinggame.domain;

public class CarSnapshot {
    private final int location;

    public CarSnapshot(final int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
