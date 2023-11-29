package racingCar.domain;

import java.util.Objects;

public class Distance {
    private int value;

    public Distance() {
        this.value = 0;
    }

    public Distance(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Negative number is not allowed for distance");
        }
    }

    public void moveForward() {
       value++;
    }

    public int getValue() {
        return value;
    }

    public Distance max(Distance distance) {
        if (this.getValue() > distance.getValue()){
            return this;
        }
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return value == distance1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
