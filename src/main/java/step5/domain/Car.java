package step5;

import java.util.Objects;

public class Car {

    private final String name;
    private int position = 0;

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean isExceedWord() {
        if (name.length() > 5) {
            return true;
        }
        return false;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
