package racingcar;

import java.text.MessageFormat;
import java.util.Objects;

public class Car {

    public static final String DASH = "-";

    private static final int MINIMUM_POWER = 4;

    private CarName name;

    private int position;

    public Car(CarName name) {
        this(name, 0);
    }

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public String statusToString() {
        return MessageFormat.format("{0} : {1}", name, DASH.repeat(position));
    }

    public void move(int power) {
        if (movable(power)) {
            this.forward();
        }
    }

    private boolean movable(int power) {
        return power >= MINIMUM_POWER;
    }

    private void forward() {
        this.position++;
    }

    public boolean matchPosition(int otherPosition) {
        return position == otherPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (position != car.position) return false;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
