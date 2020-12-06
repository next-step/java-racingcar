package racing.domain;

import java.util.Objects;

public class CarIndex {

    private final int index;

    private CarIndex(final int index) {
        this.index = index;
    }

    public static CarIndex valueOf(final int value) {
        return new CarIndex(value);
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CarIndex)) return false;
        final CarIndex carIndex = (CarIndex) o;
        return index == carIndex.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
