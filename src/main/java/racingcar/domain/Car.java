package racingcar.domain;

public class Car {

    private static final int DEFAULT_INIT_POSITION = 0;

    private final Name name;
    private int position;

    public Car(String name) {
        this(new Name(name), DEFAULT_INIT_POSITION);
    }

    public Car(String name, int position) {
        this(new Name(name), position);
    }

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy strategy) {
        if (strategy.movable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}

