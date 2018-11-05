package racing;

import racing.rule.IForward;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private int position;
    private IForward forward;

    public Car(IForward forward) {
        this.forward = forward;
        initialize();
    }

    public void run() {
        if (forward.isPossible()) {
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
