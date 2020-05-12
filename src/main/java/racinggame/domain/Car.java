package racinggame.domain;

public class Car {
    private int location;

    public int move(Engine engine) {
        if (engine.isMovable()) {
            location++;
        }
        return location;
    }
}
