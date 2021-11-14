package step3;

import java.util.Objects;

public class Car {

    public static final int MOVABLE_COUNT = 4;
    public static final int VALID_CAR_SIZE_VALUE = 5;
    public static final int DEFAULT_CAR_LOCATION_VALUE = 0;
    public static final String DEFAULT_CAR_NAME = "이름없음";
    public static final String VALID_MSG_CAR_NAME_SIZE = "자동차 이름은 5자를 초과할 수 없습니다.";

    private int location;
    private String name;

    public Car() {
        this(DEFAULT_CAR_NAME, DEFAULT_CAR_LOCATION_VALUE);
    }

    public Car(String name) {
        this(name, DEFAULT_CAR_LOCATION_VALUE);
    }

    public Car(int location) {
        this(DEFAULT_CAR_NAME, location);
    }

    public Car(String name, int location) {
        if (name.length() > VALID_CAR_SIZE_VALUE) {
            throw new IllegalArgumentException(VALID_MSG_CAR_NAME_SIZE);
        }
        this.name = name;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public Car move(int count) {
        if (count >= MOVABLE_COUNT) {
            location++;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return location == car.location && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, name);
    }
}
