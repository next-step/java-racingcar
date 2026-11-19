package racingcar.domain;

public class Car {

    private static final int DEFAULT_INIT_POSITION = 0;

    private final Name name;
    private int position;

    public Car(String name) {
        this(new Name(name), DEFAULT_INIT_POSITION);
    }

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(RandomMoveStrategy strategy) {
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

