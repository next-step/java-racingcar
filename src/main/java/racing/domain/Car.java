package racing.domain;

import racing.behavior.CarMovable;
import racing.behavior.Movable;

public class Car {
    private static final int INITIAL_LOCATION = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "자동차 이름의 길이를 확인해 주세요.";

    private final String name;
    private int location;
    private final Movable movable;

    public Car(final String name, final Movable movable) {
        this.name = validateName(name);
        this.location = INITIAL_LOCATION;
        this.movable = movable;
    }

    public static Car of(final String name, final CarMovable movable) {
        return new Car(name, movable);
    }

    public static String validateName(final String name) {
        if(name.trim().isEmpty() || name.trim().length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
        return name;
    }

    public void move() {
        if (movable.move()) {
            this.location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
