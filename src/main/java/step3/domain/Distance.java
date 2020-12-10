package step3.domain;

import java.util.Objects;

public class Distance {
    private int mileage;

    public int getMileage() {
        return mileage;
    }

    public void addMileage(int distance) {
        this.mileage += distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return mileage == distance.mileage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mileage);
    }
}
