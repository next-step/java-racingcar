package race.logic;

import java.util.Objects;

public class Car {
    private static final int LENGTH_CAR_NAME_MAX = 5;

    private final Engine engine;
    private final String name;
    private int position = 0;

    public Car(Engine engine, String name) {
        this.engine = engine;

        if (Objects.isNull(name) || name.length() > LENGTH_CAR_NAME_MAX) {
            throw new IllegalArgumentException("name");
        }
        this.name = name;
    }

    public void run() {
        if (engine.canMove()) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return position;
    }
}
