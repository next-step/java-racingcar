package racing;

import racing.rule.Forward;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private int position;

    public Car() {
        initialize();
    }

    public void run() {
        if (Forward.isPossible()) {
            increasePosition();
        }
    }

    public int getPosition() {
        return position;
    }

    private void initialize() {
        position = DEFAULT_POSITION;
    }

    private void increasePosition() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("position=").append(position);
        sb.append('}');
        return sb.toString();
    }

}
