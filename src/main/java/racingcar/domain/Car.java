package racingcar.domain;

public class Car {

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
            position += 1;
        }
    }

    public Name name() {
        return name;
    }

    public int position() {
        return position;
    }
}
