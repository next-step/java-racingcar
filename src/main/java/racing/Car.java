package racing;

import racing.rule.IForward;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private int position;
    private String name;
    private IForward forward;

    public Car(final String name, final IForward forward) {
        this.name = name;
        this.forward = forward;
        this.position = DEFAULT_POSITION;
    }

    public Car(final String name, final int position, final IForward forward) {
        this.name = name;
        this.position = position;
        this.forward = forward;
    }

    public void run() {
        if (forward.isPossible()) {
            increasePosition();
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualsPosition(final int position) {
        return this.position == position;
    }

    private void increasePosition() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name) &&
                Objects.equals(forward, car.forward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name, forward);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("position=").append(position);
        sb.append(", name='").append(name).append('\'');
        sb.append(", forward=").append(forward);
        sb.append('}');
        return sb.toString();
    }

}
