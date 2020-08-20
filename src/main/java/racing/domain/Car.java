package racing.domain;

import racing.behavior.CarMovable;
import racing.behavior.Movable;

import java.util.Objects;

public class Car {
    private static final int INITIAL_LOCATION = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "자동차 이름의 길이를 확인해 주세요.";
    private static final String INVALID_CAR_NAME = "자동차의 이름을 올바르게 입력해 주세요.";

    private final String name;
    private int location;
    private final Movable movable;

    public Car(final String name) {
        this.name = validateName(name);
        this.location = INITIAL_LOCATION;
        this.movable = new CarMovable();
    }

    public Car(final String name, final Movable movable) {
        this.name = validateName(name);
        this.location = INITIAL_LOCATION;
        this.movable = movable;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public static String validateName(final String name) {
        if(Objects.isNull(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }

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

    public boolean isCorrectMaxLocation(final int maxLocation) {
        return this.location == maxLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public boolean equals(final Object obj) {
        if(this == obj) {
            return true;
        }

        if(Objects.isNull(obj) || getClass() != obj.getClass()) {
            return false;
        }

        final Car car = (Car) obj;
        return location == car.location && Objects.equals(name, car.name);
    }
}
