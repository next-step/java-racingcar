package racingcar.domain;

public class Car {

    private static final int FORWARD_INTERVAL = 1;

    private Name name;
    private int position;
    private Engine engine;

    public Car(String name, Engine engine) {
        this.name = new Name(name);
        this.position = 0;
        this.engine = engine;
    }

    public void move() {
        if (engine.movable()) {
            position += FORWARD_INTERVAL;
        }
    }

    public Name name() {
        return name;
    }

    public int position() {
        return position;
    }
}
