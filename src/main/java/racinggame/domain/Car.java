package racinggame.domain;

public class Car {
    private int location;

    public CarSnapshot move(Engine engine) {
        if (engine.isMovable()) {
            location++;
        }

        return new CarSnapshot(location);
    }
}
