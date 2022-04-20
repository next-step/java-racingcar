package domain.car;

import java.util.Objects;

public class Max {

    private int max;

    public Max(int max) {
        this.max = max;
    }

    public void fixMaxValue(int distance) {
        if (max < distance) {
            max = distance;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Max max1 = (Max) o;
        return max == max1.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(max);
    }

}
