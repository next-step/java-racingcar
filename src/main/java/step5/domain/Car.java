package step5.domain;

import java.util.Objects;

public class Car {
    private final static int STRING_MAX_LENGTH = 5;
    private final static int RUN = 4;
    private String name;
    private int location = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int location) {
        if (name.length() > STRING_MAX_LENGTH) {
            throw new IllegalArgumentException("차 이름은 " + STRING_MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.location = location;
    }

    public void go(int condition) {
        if (RUN <= condition) {
            ++this.location;
        }
    }

    public String winner(int location) {
        if (location == this.location) {
            return name;
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
