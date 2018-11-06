package racing;

import racing.rule.IForward;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private int position;
    private IForward forward;
    private CarRacer carRacer;

    public Car(final CarRacer carRacer, final IForward forward) {
        this.carRacer = carRacer;
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

    public CarRacer getCarRacer() {
        return carRacer;
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
        return position == car.position &&
                Objects.equals(forward, car.forward) &&
                Objects.equals(carRacer, car.carRacer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, forward, carRacer);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("position=").append(position);
        sb.append(", forward=").append(forward);
        sb.append(", carRacer=").append(carRacer);
        sb.append('}');
        return sb.toString();
    }

}
