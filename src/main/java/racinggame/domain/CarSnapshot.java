package racinggame.domain;

public class CarSnapshot {
    private final int location;

    public CarSnapshot(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
