package racing.model;

public class CarSnapshot {

    private final int position;

    private final String name;

    public CarSnapshot(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
